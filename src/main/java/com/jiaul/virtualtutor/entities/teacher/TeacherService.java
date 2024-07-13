package com.jiaul.virtualtutor.entities.teacher;

import com.jiaul.virtualtutor.entities.teacher.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(TeacherDto teacherDto){
        Teacher teacher=teacherRepository.findById(teacherDto.getId()).orElseThrow();

        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPhoto(Base64.getDecoder().decode(teacherDto.getPhoto()));
        teacher.setPhone(teacherDto.getPhone());
        teacher.setGender(teacherDto.getGender());
        teacher.setLanguage(teacherDto.getLanguage());
        teacher.setCountry(teacherDto.getCountry());
        teacher.setCity(teacherDto.getCity());
        teacher.setBio(teacherDto.getBio());
        teacher.setDegree(teacherDto.getDegree());
        teacher.setSkills(teacherDto.getSkills());

        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> getTeacherById(int id){
        return teacherRepository.findById(id);
    }

    public byte[] updateProfilePhoto(MultipartFile file,int id) throws IOException {
        Teacher teacher= teacherRepository.findById(id).orElseThrow();
        teacher.setPhoto(file.getBytes());
        return teacherRepository.save(teacher).getPhoto();
    }
}
