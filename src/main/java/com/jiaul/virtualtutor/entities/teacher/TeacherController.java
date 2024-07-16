package com.jiaul.virtualtutor.entities.teacher;

import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.entities.teacher.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.createTeacher(teacher));
    }

    @PatchMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody TeacherDto teacherDto) throws IOException {
        return ResponseEntity.ok(teacherService.updateTeacher(teacherDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @GetMapping("/get/teacher/all-course/{id}")
    public ResponseEntity<List<Course>> getTeacherAllCourse(@PathVariable int id){
        return ResponseEntity.ok(teacherService.getTeacherAllCourse(id));
    }

//    @PatchMapping("/update/profile-photo/{id}")
//    public ResponseEntity<byte[]> updateProfilePhoto(@RequestParam("image") MultipartFile file, int id) throws IOException {
//        return ResponseEntity.ok(teacherService.updateProfilePhoto(file,id));
//    }
}
