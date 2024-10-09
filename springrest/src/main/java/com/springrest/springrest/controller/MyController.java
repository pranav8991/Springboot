package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService onduty;
    @GetMapping("/home")
    public String home(){
        return " this is my home";
    }
    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return this.onduty.getCourses();
    }
    @GetMapping("/courses/{courseId}")
    public Courses getCourse(@PathVariable String courseId){
        return this.onduty.getCourse(Long.parseLong(courseId));
    }
    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses course){
        return this.onduty.addCourse(course);
    }
    @PutMapping("/courses")
    public Courses updateCourse(@RequestBody Courses course){
        return this.onduty.updateCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.onduty.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
