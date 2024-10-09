package com.springrest.springrest.services;
import com.springrest.springrest.entities.Courses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service  *********************************************** its is with out using data base
public class CourseServiceimpl implements CourseService{

    List<Courses> list;

    public CourseServiceimpl() {
        list = new ArrayList<>();
        list.add(new Courses(145, "Python", "Python course its is"));
        list.add(new Courses(146, "Java", "Java course its is"));
        list.add(new Courses(147, "SpringBoot", "SpringBoot course its is"));
    }

    @Override
    public List<Courses> getCourses() {
        return list;
    }

    @Override
    public Courses getCourse(long courseId) {
        Courses c = null;
        for(Courses course : list){
            if(course.getId() == courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Courses addCourse(Courses course) {
        list.add(course);
        return course;
    }

    @Override
    public Courses updateCourse(Courses course) {
        list.forEach(e ->{
            if(e.getId()== course.getId()){
                e.setName(course.getName());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    }
}
