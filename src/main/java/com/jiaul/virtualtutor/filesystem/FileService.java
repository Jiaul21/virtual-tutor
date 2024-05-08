package com.jiaul.virtualtutor.filesystem;

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
import java.util.UUID;

@Service
public class FileService {

    private static final String BASE_PATH = "D:/java spring/University/Backend/virtual-tutor/src/main/resources/storage";

    private static final String FORMAT = "classpath:videos/%s.mp4";

//    @Value("${resource-path}")
//    private String BASE_PATH;

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
    }

    public String storeVideoFile(MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID()) + file.getOriginalFilename();
        file.transferTo(new File(BASE_PATH + "/videos/" + fileName));
        return fileName;
    }

    public byte[] getImageFile(String image) throws IOException {
        return Files.readAllBytes(new File(BASE_PATH + "/images/" + image).toPath());
    }

    public String storeImageFile(MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID()) + file.getOriginalFilename();
        file.transferTo(new File(BASE_PATH + "/images/" + fileName));
        return fileName;
    }

    public String storePdfFile(MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID()) + file.getOriginalFilename();
        file.transferTo(new File(BASE_PATH + "/pdf/" + fileName));
        return fileName;
    }


}
