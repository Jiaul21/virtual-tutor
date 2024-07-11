package com.jiaul.virtualtutor.fileserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileManagementService {

    private static final String BASE_PATH = "D:/java spring/University/Backend/virtual-tutor/src/main/resources";
    private static final String COURSE_PATH = BASE_PATH + "/file-storage/course";

    @Autowired
    private FileService fileService;

    public String storeCourseImage(MultipartFile file) throws IOException {
        String courseImagePath = COURSE_PATH + "/course-image/";
        return courseImagePath+ fileService.storeFiles(file, courseImagePath);
    }

    public String storeModuleThumbnail(MultipartFile file) throws IOException {
        String moduleThumbnailPath = COURSE_PATH + "/module-thumbnail/";
        return moduleThumbnailPath + fileService.storeFiles(file, moduleThumbnailPath);
    }

    public String storeCourseVideo(MultipartFile file) throws IOException {
        String courseVideoPath=COURSE_PATH+"/videos/";
        return courseVideoPath+ fileService.storeFiles(file,courseVideoPath);
    }


}
