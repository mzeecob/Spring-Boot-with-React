package com.example.springbootwithreact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseResource {
    @Autowired
    private CoursesHardcodedService coursesHardcodedService;

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username){
        return coursesHardcodedService.findAll();
    }

}
