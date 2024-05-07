package com.jiaul.virtualtutor.entities.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content UpdateContent(Content content) {
        return contentRepository.save(content);
    }


}
