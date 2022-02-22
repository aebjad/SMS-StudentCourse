package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseDAO {

    // declaring entity factory and manager
    EntityManagerFactory factory;
    EntityManager manager;

    //getAllCourses –This method takes no parameter and returns every Course in the table.
    @Override
    public List<Course> getAllCourses(){

        connect(); // // initializing entity factory and manager

        try {
           Query query = manager.createQuery("SELECT c FROM Course c", Course.class);
           List<Course> allCourses = query.getResultList();

           disconnect();
           return allCourses;

       } catch (Exception e){
           System.out.println("getAllCourses : " + e.getMessage());
           disconnect();
           return null;
       }

    }

    public Course getCourseById(int cId) {
       connect();

        Course course = new Course();

        try {
            course = manager.find(Course.class, cId);
        } catch (Exception e) {
            System.out.println("getCourseById : " + e.getMessage());
            return null;
       } finally {
           disconnect();
        }
        return course;
    }

    public void connect() {

        factory = Persistence.createEntityManagerFactory("SMS");
        manager = factory.createEntityManager();
    }

    public void disconnect() {
        if (manager != null) {
            manager.close();
        }
        if (factory != null) {
            manager.close();
        }
    }
}
