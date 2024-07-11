package com.jiaul.virtualtutor.entities.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> getTeacherById(int id){
        return teacherRepository.findById(id);
    }
}
