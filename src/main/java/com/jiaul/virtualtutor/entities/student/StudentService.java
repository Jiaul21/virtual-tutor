package com.jiaul.virtualtutor.entities.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public int countTotalStudents(){
        return (int) studentRepository.count();
    }
}
