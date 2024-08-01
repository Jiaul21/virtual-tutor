package com.jiaul.virtualtutor.entities.teacher;

import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.entities.course.dto.CourseResponse;
import com.jiaul.virtualtutor.entities.teacher.dto.TeacherDto;
import com.jiaul.virtualtutor.fileserver.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public List<CourseResponse> getTeacherAllCourse(int id){
        Teacher teacher= teacherRepository.findById(id).orElseThrow();
        List<CourseResponse> courseResponses=new ArrayList<>();

        teacher.getSellCourses().forEach(course -> {
            CourseResponse c=new CourseResponse();
            c.setId(course.getId());
            c.setTitle(course.getTitle());
            c.setImage(course.getImage());
            c.setType(course.getType());
            c.setCategory(course.getCategory());
            c.setDuration(course.getDuration());
            c.setDescription(course.getDescription());
            c.setRating(course.getRating());
            c.setPrice(course.getPrice());
            c.setOffer(course.getOffer());
            c.setPublishingDateTime(course.getPublishingDateTime());
            c.setActive(course.isActive());
            c.setCourseModules(course.getCourseModules());
            c.setCourseStudents(course.getCourseStudents());
            c.setCourseTeacher(teacher.getId());

            courseResponses.add(c);
        });

        return courseResponses;
    }

    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public int countTotalTeachers(){
        return (int) teacherRepository.count();
    }

//    public byte[] updateProfilePhoto(MultipartFile file,int id) throws IOException {
//        Teacher teacher= teacherRepository.findById(id).orElseThrow();
//        teacher.setPhoto(file.getBytes());
//        return teacherRepository.save(teacher).getPhoto();
//    }

}
