package com.jiaul.virtualtutor.entities.course;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByType(String type);

    List<Course> findByCategory(String category);

    long countByCategory(String category);

}
