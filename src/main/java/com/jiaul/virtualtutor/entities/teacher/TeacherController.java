package com.jiaul.virtualtutor.entities.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api-teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.createTeacher(teacher));
    }

    @PatchMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.updateTeacher(teacher));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Teacher>> getTeacherById(int id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }
}
