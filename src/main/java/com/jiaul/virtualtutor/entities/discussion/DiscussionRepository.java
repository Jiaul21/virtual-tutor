package com.jiaul.virtualtutor.entities.discussion;

import com.jiaul.virtualtutor.entities.module.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion,Integer> {


    List<Discussion> findAllByCourseModuleAndParentMessageId
            (CourseModule courseModule, Integer parentMessageId);

}
