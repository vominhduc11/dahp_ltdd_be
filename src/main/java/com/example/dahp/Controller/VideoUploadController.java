package com.example.dahp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.dahp.Service.VideoUploadService;

import java.io.IOException;

@RestController
@RequestMapping("/api/videos")
public class VideoUploadController {

    @Autowired
    private VideoUploadService videoUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            String videoUrl = videoUploadService.uploadVideo(file);
            return ResponseEntity.ok("Video uploaded successfully: " + videoUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading video: " + e.getMessage());
        }
    }
}
