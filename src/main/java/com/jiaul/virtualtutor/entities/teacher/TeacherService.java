package com.jiaul.virtualtutor.entities.teacher;

import com.jiaul.virtualtutor.entities.teacher.dto.TeacherDto;
import com.jiaul.virtualtutor.fileserver.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private FileService fileService;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(TeacherDto teacherDto) throws IOException {
        Teacher teacher = teacherRepository.findById(teacherDto.getId()).orElseThrow();

        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPhoto(fileService.storeBase64(teacherDto.getPhoto()));
        teacher.setPhone(teacherDto.getPhone());
        teacher.setGender(teacherDto.getGender());
        teacher.setLanguage(teacherDto.getLanguage());
        teacher.setCountry(teacherDto.getCountry());
        teacher.setCity(teacherDto.getCity());
        teacher.setBio(teacherDto.getBio());
        teacher.setDegree(teacherDto.getDegree());
        teacher.setSkills(teacherDto.getSkills());

        teacher = teacherRepository.save(teacher);
        teacher.setPhoto(fileService.getBase64(teacher.getPhoto()));

        return teacher;
    }

    public Teacher getTeacherById(int id) {

        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacher.setPhoto(fileService.getBase64(teacher.getPhoto()));
        return teacher;
    }

//    public byte[] updateProfilePhoto(MultipartFile file,int id) throws IOException {
//        Teacher teacher= teacherRepository.findById(id).orElseThrow();
//        teacher.setPhoto(file.getBytes());
//        return teacherRepository.save(teacher).getPhoto();
//    }

}
