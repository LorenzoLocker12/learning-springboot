package com.lorenzo.cruddemo.dao;

import com.lorenzo.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
}
