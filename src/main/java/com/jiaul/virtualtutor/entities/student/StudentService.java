package com.jiaul.virtualtutor.entities.student;

import com.jiaul.virtualtutor.fileserver.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private FileService fileService;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(int id){

        Student student=studentRepository.findById(id).orElseThrow();
        student.setPhoto(fileService.getBase64(student.getPhoto()));
        return student;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public int countTotalStudents(){
        return (int) studentRepository.count();
    }
}
