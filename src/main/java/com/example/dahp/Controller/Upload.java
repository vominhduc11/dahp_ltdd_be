package com.example.dahp.Controller;

import com.example.dahp.Entity.Video_short;
import com.example.dahp.Repository.Video_shortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/api/files")
public class Upload {
    @Autowired
    private Video_shortRepository video_shortRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("video") MultipartFile file) {
        try {
            // Lưu file vào thư mục tạm thời (có thể thay đổi đường dẫn)
            String uploadDir = System.getProperty("user.dir") + "/uploads/video";
            File directory = new File(uploadDir);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            File destinationFile = new File(uploadDir + "/" + file.getOriginalFilename());
            file.transferTo(destinationFile);

            Video_short video = new Video_short();
            video.setLink(file.getOriginalFilename());
            video_shortRepository.save(video);

            return new ResponseEntity<>("File uploaded successfully: " + file.getOriginalFilename(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
