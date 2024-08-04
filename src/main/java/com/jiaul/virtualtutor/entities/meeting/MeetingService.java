package com.jiaul.virtualtutor.entities.meeting;

import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.entities.meeting.dto.MeetingDto;
import com.jiaul.virtualtutor.entities.task.Task;
import com.jiaul.virtualtutor.entities.task.TaskService;
import com.jiaul.virtualtutor.enums.TaskType;
import com.jiaul.virtualtutor.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private Scheduler scheduler;

    public MeetingDto createMeeting(MeetingDto meetingDto){
        Meeting meeting=meetingRepository.save(toMeeting(meetingDto));

        Task task = new Task();
        task.setTaskType(TaskType.MEETING_NOTIFY.toString());
        task.setDone(false);
        task.setDateTime(new Date());
        task.setCourse(meeting.getCourse());
        taskService.createTask(task);
        scheduler.setChanged(true);

         return toMeetingDto(meeting);
    }

    public MeetingDto getMeetingByCourseId(int id){
        Course course=new Course();
        course.setId(id);
        return toMeetingDto(meetingRepository.findByCourse(course));
    }


    public MeetingDto toMeetingDto(Meeting meeting){
        MeetingDto meetingDto=new MeetingDto();
        meetingDto.setId(meeting.getId());
        meetingDto.setTitle(meeting.getTitle());
        meetingDto.setMeetingLink(meeting.getMeetingLink());
        meetingDto.setMeetingTime(meeting.getMeetingTime());
        meetingDto.setCourse(meeting.getCourse().getId());
        return meetingDto;
    }

    public Meeting toMeeting(MeetingDto meetingDto){
        Course course=new Course();
        course.setId(meetingDto.getCourse());

        Meeting meeting=new Meeting();
        meeting.setId(meetingDto.getId());
        meeting.setTitle(meetingDto.getTitle());
        meeting.setMeetingLink(meetingDto.getMeetingLink());
        meeting.setMeetingTime(meetingDto.getMeetingTime());
        meeting.setCourse(course);
        return meeting;
    }
}