package com.jiaul.virtualtutor.entities.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PatchMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
}
