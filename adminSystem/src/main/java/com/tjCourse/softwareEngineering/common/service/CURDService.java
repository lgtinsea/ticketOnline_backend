package com.tjCourse.softwareEngineering.common.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface CURDService<E, IDTYPE> {

    E add(E one);

    void deleteById(IDTYPE id);

    void update(IDTYPE id, E one);

    E queryById(IDTYPE id);

    List<E> queryAll();

}
