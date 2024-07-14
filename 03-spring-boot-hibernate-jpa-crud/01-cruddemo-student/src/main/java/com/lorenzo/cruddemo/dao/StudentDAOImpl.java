package com.lorenzo.cruddemo.dao;


import com.lorenzo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query =
                entittyManager.createQuery("FROM Student order by firstName asc", Student.class);

        // return query result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create a query
        TypedQuery<Student> query =
                entittyManager.createQuery("FROM Student WHERE lastName=:data", Student.class);

        // set query parameters
        query.setParameter("data", lastName);

        // return query result
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entittyManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entittyManager.find(Student.class, id);
        entittyManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rows = entittyManager.createQuery("DELETE FROM Student").executeUpdate();
        return rows;
    }

}
