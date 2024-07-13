package com.lorenzo.cruddemo.dao;


import com.lorenzo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entittyManager;


    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entittyManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entittyManager.persist(student);
    }

    @Override
    public Student findById(Integer id){
        return entittyManager.find(Student.class, id);
    }

}
