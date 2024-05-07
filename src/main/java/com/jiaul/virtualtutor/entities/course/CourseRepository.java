package com.jiaul.virtualtutor.entities.course;

import com.jiaul.virtualtutor.entities.userprofile.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByType(String type);

    List<Course> findByCategory(String category);

    List<Course> findByInstructor(UserProfile instructor);
}
