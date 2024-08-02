package com.jiaul.virtualtutor.entities.discussion;

import com.jiaul.virtualtutor.entities.discussion.dto.DiscussionDto;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    public Discussion createDiscussion(Discussion discussion){
        discussion.setDateTime(new Date());
        return discussionRepository.save(discussion);
    }

    public List<DiscussionDto> getAllDiscussionByModuleId(int id){
        CourseModule courseModule=new CourseModule();
        courseModule.setId(id);

     return mapDiscussionlistToDiscussionDtoList(
             discussionRepository.findAllByCourseModuleAndParentMessageId(
                     courseModule,0));
    }
    public List<DiscussionDto> mapDiscussionlistToDiscussionDtoList(List<Discussion> discussions){
        List<DiscussionDto> discussionDtoList=new ArrayList<>();

        discussions.forEach(discussion -> {
            DiscussionDto discussionDto=new DiscussionDto();
            discussionDto.setId(discussion.getId());
            discussionDto.setMessage(discussion.getMessage());
            discussionDto.setImage(discussion.getImage());
            discussionDto.setDateTime(discussion.getDateTime());
            discussionDto.setVote(discussion.getVote());
            discussionDto.setSenderId(discussion.getSenderId());
            discussionDto.setSenderRole(discussion.getSenderRole());
            discussionDto.setCourseModuleId(discussion.getCourseModule().getId());
            discussionDto.setParentMessageId(discussion.getParentMessageId());

            discussionDto.setReplies(mapDiscussionlistToDiscussionDtoList(discussion.getReplies())); // recursive call for replies

            discussionDtoList.add(discussionDto);
        });
        return discussionDtoList;
    }

    public int countTotalDiscussion(){
        return (int) discussionRepository.count();
    }

}
