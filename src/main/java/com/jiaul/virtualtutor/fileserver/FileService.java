package com.jiaul.virtualtutor.fileserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    private static final String FORMAT = "classpath:files/videos/%s";

    private static final String BASE_PATH="D:/java spring/University/Backend/virtual-tutor/target/classes/files/";
    private String videoPath = BASE_PATH + "videos/";
    private String imagePath = BASE_PATH + "images/";
    private String pdfPath=BASE_PATH+"pdf/";
    private String docPath=BASE_PATH+"doc/";
    private  String picPath=BASE_PATH+"pic/";
    private  String pptPath=BASE_PATH+"ppt/";


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
        String originalName = file.getOriginalFilename();
        String fileName = String.valueOf(UUID.randomUUID()) + originalName.substring(originalName.lastIndexOf('.'));
        file.transferTo(new File(imagePath + fileName));
        return fileName;
    }

    public byte[] getImageFile(String image) throws IOException {
        return Files.readAllBytes(new File(imagePath + image).toPath());
    }

    public String storePdfFile(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String fileName = String.valueOf(UUID.randomUUID()) + originalName.substring(originalName.lastIndexOf('.'));
        file.transferTo(new File(pdfPath + fileName));
        return fileName;
    }
    public byte[] getPdfFile(String pdf) throws IOException {
        return Files.readAllBytes(new File(pdfPath + pdf).toPath());
    }
    public String storeDocFile(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String fileName = String.valueOf(UUID.randomUUID()) + originalName.substring(originalName.lastIndexOf('.'));
        file.transferTo(new File(docPath + fileName));
        return fileName;
    }
    public byte[] getDocFile(String pdf) throws IOException {
        return Files.readAllBytes(new File(docPath + pdf).toPath());
    }

    public String storePptFile(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String fileName = String.valueOf(UUID.randomUUID()) + originalName.substring(originalName.lastIndexOf('.'));
        file.transferTo(new File(pptPath + fileName));
        return fileName;
    }
    public byte[] getPptFile(String pdf) throws IOException {
        return Files.readAllBytes(new File(pptPath + pdf).toPath());
    }

    public String storeAnyFile(MultipartFile file) throws IOException {

        String originalName=file.getOriginalFilename();
        String newName="";
        String fileType=originalName.substring(originalName.lastIndexOf('.'));

        if(fileType.equals(".mp4") || fileType.equals(".mkv")){
            newName=storeVideoFile(file);
        } else if (fileType.equals(".pdf")) {
            newName=storePdfFile(file);
        } else if (fileType.equals(".docx")) {
            newName=storeDocFile(file);
        }else if (fileType.equals(".ppt")) {
            newName=storePptFile(file);
        }
        return newName;
    }

    public String getAnyFile(MultipartFile file) throws IOException {

        String originalName=file.getOriginalFilename();
        String newName="";
        String fileType=originalName.substring(originalName.lastIndexOf('.'));

        if(fileType.equals(".mp4") || fileType.equals(".mkv")){
            newName=storeVideoFile(file);
        } else if (fileType.equals(".pdf")) {
            newName=storePdfFile(file);
        } else if (fileType.equals(".docx")) {
            newName=storeDocFile(file);
        }else if (fileType.equals(".ppt")) {
            newName=storePptFile(file);
        }
        return newName;
    }





    public String storeBase64(String base64){
        String fileName= String.valueOf(UUID.randomUUID())+".txt";
        try {
            FileWriter file = new FileWriter(picPath+fileName);
            file.write(base64);
            file.close();
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
        return fileName;
    }

    public String getBase64(String name){
        String base64="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(picPath+name));
            String line;
            while ((line = br.readLine()) != null) {
                base64=base64+line;
            }
            br.close();
        } catch(IOException e) {
            System.out.println("Error: " + e);
        }
        return base64;
    }

}
