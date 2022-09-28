package com.example.sqlsandbox.course;

import com.example.sqlsandbox.product.ProductItem;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/post")
    public ResponseEntity<Course> postCourse(@RequestBody CourseDTO course) {
        Course course2Save = Course.builder().description(course.description).title(course.title).build();
        Course savedCourse = courseRepository.save(course2Save);
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return ResponseEntity.ok(courseList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") String id) {
        Optional<Course> courseToDelete = courseRepository.findById(id);
        String courseId = "";
        String courseTitle = "";
        if(courseToDelete.isPresent()){
            courseId = courseToDelete.get().getId();
            courseTitle = courseToDelete.get().getTitle();
        }
        courseToDelete.ifPresent(courseItem -> courseRepository.delete(courseItem));

        return ResponseEntity.ok("Kurs: " + courseTitle + ", mit id: " + courseId + ", wurde gelöscht.");
    }
}
