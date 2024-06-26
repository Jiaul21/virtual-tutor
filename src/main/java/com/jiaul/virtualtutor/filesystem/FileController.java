package com.jiaul.virtualtutor.filesystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private  FileService fileService;

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        return fileService.getVideo(title);
    }

    @PostMapping("/upload/video")
    public ResponseEntity<?> storeVideoFile(@RequestParam("video") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.storeVideoFile(file));
    }

    @PostMapping("/upload/image")
    public ResponseEntity<?> storeImageFile(@RequestParam("image") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.storeImageFile(file));
    }

    @PostMapping("/upload/pdf")
    public ResponseEntity<?> storePdfFile(@RequestParam("pdf") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileService.storeVideoFile(file));
    }

    @GetMapping("/image/{image}")
    public ResponseEntity<?> getImageFile(@PathVariable String image) throws IOException{
        byte[] imageFile= fileService.getImageFile(image);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(imageFile);
    }
    @GetMapping("/doc/{file}")
    public ResponseEntity<?> getFileByName(@PathVariable String file) throws IOException{
        byte[] image= fileService.getImageFile(file);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF).body(image);
    }

//    @GetMapping("/images/{image}")
//    public ResponseEntity<?> getImage(@PathVariable String image) throws IOException{
//        byte[] imageData= fileService.getImageFile(image);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
//    }
}
