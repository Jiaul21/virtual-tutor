package com.jiaul.virtualtutor.entities.course;

import com.jiaul.virtualtutor.entities.course.dto.CourseRequest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest courseRequest) throws IOException {
        return ResponseEntity.ok(courseService.createCourse(courseRequest));
    }

    @GetMapping("/buy/{sid}/{cid}")
    public ResponseEntity<Course> buyCourse(@PathVariable int sid, @PathVariable int cid){
        return ResponseEntity.ok(courseService.buyCourse(cid,sid));
    }

//    @PatchMapping("/update")
//    public ResponseEntity<Course> updateCourse(@Valid @RequestBody CourseRequest courseRequest) {
//        return ResponseEntity.ok(courseService.updateCourse(courseRequest));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable int courseId) {
        return ResponseEntity.ok(courseService.getCourseByID(courseId));
    }
    @GetMapping("/{type}")
    public ResponseEntity<List<Course>> getCourseByType(@PathVariable String type) {
        return ResponseEntity.ok(courseService.getCourseByType(type));
    }
    @GetMapping("/{category}")
    public ResponseEntity<List<Course>> getCourseByCategory(@PathVariable String category) {
        return ResponseEntity.ok(courseService.getCourseByCategory(category));
    }
//    @GetMapping("/{instructor}")
//    public ResponseEntity<List<Course>> getCourseByInstructor(@PathVariable UserProfile instructor) {
//        return ResponseEntity.ok(courseService.getCourseByInstructor(instructor));
//    }
}
