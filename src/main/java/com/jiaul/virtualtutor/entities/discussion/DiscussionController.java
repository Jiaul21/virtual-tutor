package com.jiaul.virtualtutor.entities.discussion;

import com.jiaul.virtualtutor.entities.discussion.dto.DiscussionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @GetMapping("/get-all/{moduleId}")
    public ResponseEntity<List<DiscussionDto>> getAllDiscussionByModuleId(@PathVariable int moduleId){
        System.out.println("module id: "+moduleId);
        return ResponseEntity.ok(discussionService.getAllDiscussionByModuleId(moduleId));
    }

    @PostMapping("/save")
    public ResponseEntity<DiscussionDto> createDiscussion(@RequestBody DiscussionDto discussionDto){
        return ResponseEntity.ok(discussionService.createDiscussion(discussionDto));
    }
}
