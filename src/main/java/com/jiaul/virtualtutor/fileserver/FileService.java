package com.jiaul.virtualtutor.fileserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    private static final String FORMAT = "classpath:files/videos/%s";

    private String BASE_PATH="D:/java spring/University/Backend/virtual-tutor/target/classes/files/";
    private String videoPath = BASE_PATH + "videos/";
    private String imagePath = BASE_PATH + "images/";

    @Autowired
    private ResourceLoader resourceLoader;

    public String storeVideoFile(MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID()) + ".mp4";
        file.transferTo(new File(videoPath + fileName));
        return fileName;
    }

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
    }

    public String storeImageFile(MultipartFile file) throws IOException {
        System.out.println(BASE_PATH);
        System.out.println(imagePath);
        String originalName = file.getOriginalFilename();
        String fileName = String.valueOf(UUID.randomUUID()) + originalName.substring(originalName.lastIndexOf('.'));
        file.transferTo(new File(imagePath + fileName));
        return fileName;
    }

    public byte[] getImageFile(String image) throws IOException {
        return Files.readAllBytes(new File(imagePath + image).toPath());
    }


    public List<String> storeMultipleImageFile(List<MultipartFile> files) {
        List<String> fileNameList = new ArrayList<>();
        files.forEach(file -> {
            String fileName = String.valueOf(UUID.randomUUID()) + file.getOriginalFilename();
            try {
                file.transferTo(new File(BASE_PATH + "/images/" + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileNameList.add(fileName);
        });
        System.out.println(fileNameList);
        return fileNameList;
    }

    public String storePdfFile(MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID()) + file.getOriginalFilename();
        file.transferTo(new File(BASE_PATH + "/pdf/" + fileName));
        return fileName;
    }

    public String storeFiles(MultipartFile file, String path) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID()) + file.getOriginalFilename();
        file.transferTo(new File(path + fileName));
        return fileName;
    }

}
