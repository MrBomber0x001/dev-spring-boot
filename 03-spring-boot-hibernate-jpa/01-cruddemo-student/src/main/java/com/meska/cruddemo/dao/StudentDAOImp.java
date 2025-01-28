package com.meska.cruddemo.dao;

import com.meska.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; // from the Spring framework itself

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImp(EntityManager thentityManager){
        entityManager = thentityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        // create the query
        TypedQuery<Student> typedQuery = entityManager.createQuery("From Student", Student.class); // name of the entity table, not the class

        // return the query results
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String condition){
        TypedQuery<Student> typedQuery = entityManager.createQuery("From Student WHERE lastName=:theData", Student.class);
        typedQuery.setParameter("theData", condition);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id){
        // retrieve Student By id
        Student myStudent = this.findById(id);

        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int rowsAffected = entityManager.createQuery("DELETE from Student").executeUpdate();
        return rowsAffected;
    }
}
