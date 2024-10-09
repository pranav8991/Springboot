package com.springrest.springrest.services;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service  *********************************************** its is with using database
public class CourseServiceimpl1 implements CourseService{

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Courses> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Courses getCourse(long courseId) {
        return courseDao.getOne(courseId);
    }

    @Override
    public Courses addCourse(Courses course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Courses updateCourse(Courses course) {
        courseDao.save(course);//koi method present nhi ha yeah jo value store ha usi valur ko update kar dega
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        Courses entity  = courseDao.getOne(parseLong);
        courseDao.delete(entity);
    }
}
