package com.jiaul.virtualtutor.entities.meeting;

import com.jiaul.virtualtutor.entities.meeting.dto.MeetingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping("/create")
    public ResponseEntity<MeetingDto> createMeeting(@RequestBody MeetingDto meetingDto){
        return ResponseEntity.ok(meetingService.createMeeting(meetingDto));
    }

    @GetMapping("/get/{courseId}")
    public ResponseEntity<MeetingDto> getMeetingByCourseId(@PathVariable int courseId){
        return ResponseEntity.ok(meetingService.getMeetingByCourseId(courseId));
    }
}
