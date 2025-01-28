package com.meska.cruddemo.dao;

import com.meska.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String column);
    void update(Student student);
    void deleteById(Integer id);
    int deleteAll();
}
