package com.jiaul.virtualtutor.entities.discussion;

import com.jiaul.virtualtutor.entities.discussion.dto.DiscussionDto;
import com.jiaul.virtualtutor.entities.student.Student;
import com.jiaul.virtualtutor.entities.student.StudentService;
import com.jiaul.virtualtutor.entities.teacher.Teacher;
import com.jiaul.virtualtutor.entities.teacher.TeacherService;
import com.jiaul.virtualtutor.enums.RoleEnum;
import com.jiaul.virtualtutor.fileserver.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FileService fileService;

    public DiscussionDto createDiscussion(DiscussionDto discussionDto) {
        return toDiscussionDto(discussionRepository.save(toDiscussion(discussionDto)));
    }

    public List<DiscussionDto> getAllDiscussionByModuleId(int id) {
        return mapDiscussionlistToDiscussionDtoList(
                discussionRepository.findAllByCourseModuleIdAndParentMessage(
                        id, null));
    }

    public List<DiscussionDto> mapDiscussionlistToDiscussionDtoList(List<Discussion> discussions) {
        List<DiscussionDto> discussionDtoList = new ArrayList<>();

        discussions.forEach(discussion -> {
            discussionDtoList.add(toDiscussionDto(discussion));
        });
        return discussionDtoList;
    }

    public Discussion toDiscussion(DiscussionDto discussionDto) {
        Discussion discussion = new Discussion();
        discussion.setId(discussionDto.getId());
        discussion.setMessage(discussionDto.getMessage());
        discussion.setImage(discussionDto.getImage());
        discussion.setDateTime(new Date());
        discussion.setVote(discussionDto.getVote());
        discussion.setCourseModuleId(discussionDto.getCourseModuleId());

        if (discussionDto.getSenderRole().equals(RoleEnum.STUDENT.toString())) {
            discussion.setStudent(studentService.getStudentById(discussionDto.getSenderId()));
        }
        else if (discussionDto.getSenderRole().equals(RoleEnum.TEACHER.toString())) {
            discussion.setTeacher(teacherService.getTeacherById(discussionDto.getSenderId()));
        }
        if (discussionDto.getParentMessageId() != 0) {
            Discussion parentDiscussion = new Discussion();
            parentDiscussion.setId(discussionDto.getParentMessageId());
            discussion.setParentMessage(parentDiscussion);
        }
        return discussion;
    }

    public DiscussionDto toDiscussionDto(Discussion discussion) {
        DiscussionDto discussionDto = new DiscussionDto();
        discussionDto.setId(discussion.getId());
        discussionDto.setMessage(discussion.getMessage());
        discussionDto.setImage(discussion.getImage());
        discussionDto.setDateTime(discussion.getDateTime());
        discussionDto.setVote(discussion.getVote());
        discussionDto.setCourseModuleId(discussion.getCourseModuleId());

        if (discussion.getStudent() != null) {
            discussionDto.setSenderId(discussion.getStudent().getId());
            discussionDto.setSenderName(discussion.getStudent().getFirstName());
            discussionDto.setSenderRole(discussion.getStudent().getUserCredential().getRole());
            discussionDto.setSenderPhoto(fileService.getBase64(discussion.getStudent().getPhoto()));
        } else if (discussion.getTeacher() != null) {
            discussionDto.setSenderId(discussion.getTeacher().getId());
            discussionDto.setSenderName(discussion.getTeacher().getFirstName());
            discussionDto.setSenderRole(discussion.getTeacher().getUserCredential().getRole());
            discussionDto.setSenderPhoto(fileService.getBase64(discussion.getTeacher().getPhoto()));
        }
        if(discussion.getReplies()!=null){
            List<DiscussionDto> replies = new ArrayList<>();
            discussion.getReplies().forEach(reply -> {
                DiscussionDto discussionDto1 = new DiscussionDto();
                discussionDto1 = toDiscussionDto(reply);
                replies.add(discussionDto1);
            });
            discussionDto.setReplies(replies);
        }
        return discussionDto;
    }

    public int countTotalDiscussion() {
        return (int) discussionRepository.count();
    }
}
