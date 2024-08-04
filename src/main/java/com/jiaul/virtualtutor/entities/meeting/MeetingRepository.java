package com.jiaul.virtualtutor.entities.meeting;

import com.jiaul.virtualtutor.entities.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Integer> {

    Meeting findByCourse(Course course);
}
