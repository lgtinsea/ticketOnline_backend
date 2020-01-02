package com.tjCourse.softwareEngineering.backend.shiro.jwt;

import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import com.tjCourse.softwareEngineering.backend.entity.User;
import com.tjCourse.softwareEngineering.backend.service.UserService;
import com.tjCourse.softwareEngineering.backend.utils.JWTUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class JwtRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(JwtRealm.class);

    @Autowired
    private UserService userService;

/*
    @Autowired
    private NormalAdminService normalAdminService;

    @Autowired
    SeniorAdminService seniorAdminService;
*/

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String role = JWTUtil.getRole(principals.toString());
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        if (role.equals("user")) {
            String account = JWTUtil.getUsername(principals.toString());
            User user = userService.getUserByEmail(account);
            if (user == null) {
                throw new UnauthorizedException("Token error!");
            }
            roles.add("user");
            permissions.add("user");
        }else {
            throw new UnauthorizedException("Token error!");
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();

        // 解密获得username & role，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        String role = JWTUtil.getRole(token);
        if (username == null || role == null) {
            throw new AuthenticationException("token invalid");
        }

        String password = null;

        if (role.equals("user")) {
            User user = userService.getUserByEmail(username);
            if (user == null) {
                throw new AuthenticationException("User didn't existed!");
            }
            password = user.getPassword();
        }
/*
        if (role.equals("normalAdmin")) {
            NormalAdmin admin = normalAdminService.getNormalAdminByEmail(username);
            if (admin == null) {
                throw new AuthenticationException("Admin didn't existed!");
            }
            password = admin.getPassword();
        }else if (role.equals("seniorAdmin")){
            SeniorAdmin admin = seniorAdminService.getSeniorAdminByEmail(username);
            if (admin == null) {
                throw new AuthenticationException("Admin didn't existed!");
            }
            password = admin.getPassword();
        }*/

        if (! JWTUtil.verify(token, username, password)) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "jwt_realm");
    }

}