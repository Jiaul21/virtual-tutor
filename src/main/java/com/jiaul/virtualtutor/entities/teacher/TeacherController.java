package com.jiaul.virtualtutor.entities.teacher;

import com.jiaul.virtualtutor.entities.teacher.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<Teacher> updateTeacher(@RequestBody TeacherDto teacherDto){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(teacherDto);
        return ResponseEntity.ok(teacherService.updateTeacher(teacherDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Teacher>> getTeacherById(int id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PatchMapping("/update/profile-photo/{id}")
    public ResponseEntity<byte[]> updateProfilePhoto(@RequestParam("image") MultipartFile file, int id) throws IOException {
        return ResponseEntity.ok(teacherService.updateProfilePhoto(file,id));
    }
}
