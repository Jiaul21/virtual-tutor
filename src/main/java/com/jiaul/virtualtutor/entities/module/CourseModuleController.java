package com.jiaul.virtualtutor.entities.module;

import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import com.jiaul.virtualtutor.entities.module.dto.CourseModuleResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/module")
public class CourseModuleController {

    @Autowired
    private CourseModuleService courseModuleService;

    @PostMapping("/add")
    public ResponseEntity<CourseModule> addCourseModule(@RequestBody CourseModuleRequest courseModuleRequest) throws IOException {
        return ResponseEntity.ok(courseModuleService.addCourseModule(courseModuleRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModule> getCourseModuleById(@PathVariable int id){
        return ResponseEntity.ok(courseModuleService.getCourseModuleById(id));
    }

    @GetMapping("/get-all/{id}")
    public ResponseEntity<List<CourseModuleResponse>> getAllModuleByCourseId(@PathVariable int id){
        return ResponseEntity.ok(courseModuleService.getAllModuleByCourseId(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourseModuleById(@PathVariable int id){
        return ResponseEntity.ok(courseModuleService.deleteCourseModuleById(id));
    }

}
