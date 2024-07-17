package com.jiaul.virtualtutor.entities.module;

import com.jiaul.virtualtutor.entities.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseModuleRepository extends JpaRepository<CourseModule,Integer> {
    List<CourseModule> findAllByCourse(Course course);
}
