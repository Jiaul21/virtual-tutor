package com.jiaul.virtualtutor.entities.course;

import com.jiaul.virtualtutor.entities.course.dto.CourseRequest;
import com.jiaul.virtualtutor.entities.course.dto.CourseResponse;
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
    public ResponseEntity<Course> buyCourse(@PathVariable int sid, @PathVariable int cid) {
        return ResponseEntity.ok(courseService.buyCourse(cid, sid));
    }

//    @PatchMapping("/update")
//    public ResponseEntity<Course> updateCourse(@Valid @RequestBody CourseRequest courseRequest) {
//        return ResponseEntity.ok(courseService.updateCourse(courseRequest));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable int id) {
        return ResponseEntity.ok(courseService.getCourseByID(id));
    }

    @GetMapping("/get/{type}")
    public ResponseEntity<List<Course>> getCourseByType(@PathVariable String type) {
        return ResponseEntity.ok(courseService.getCourseByType(type));
    }

    @GetMapping("/get-category")
    public ResponseEntity<List<CourseResponse>> getCourseByCategory(@RequestParam(value = "category") String category) {
        return ResponseEntity.ok(courseService.getCourseByCategory(category));
    }

    @GetMapping("/get-all/{sid}")
    public ResponseEntity<List<CourseResponse>> getAllCourseByStudentId(@PathVariable int sid){
        return ResponseEntity.ok(courseService.getAllCourseByStudentId(sid));
    }

    @PatchMapping("/set-status")
    public ResponseEntity<CourseResponse> setCourseStatus(@RequestParam(value = "courseId") int courseId,
                                                  @RequestParam(value = "status") boolean status){
        return ResponseEntity.ok(courseService.setCourseActiveStatus(courseId,status));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCourseById(@PathVariable int id){
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }

}
