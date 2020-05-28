package com.example.springbootwithreact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CourseResource {
    @Autowired
    private CoursesHardcodedService coursesHardcodedService;

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username){
        return coursesHardcodedService.findAll();
    }

    @DeleteMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable long id){
        Course course = coursesHardcodedService.deleteById(id);
        if (course != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
