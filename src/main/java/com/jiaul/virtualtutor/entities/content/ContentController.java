package com.jiaul.virtualtutor.entities.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PatchMapping("/update")
    public ResponseEntity<Content> updateContent(Content content){
        return ResponseEntity.ok(contentService.UpdateContent(content));
    }
}
