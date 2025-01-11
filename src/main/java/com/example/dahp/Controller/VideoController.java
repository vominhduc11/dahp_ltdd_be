package com.example.dahp.Controller;

import com.example.dahp.Entity.Video;
import com.example.dahp.Entity.Video_short;
import com.example.dahp.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping(value = "/getAllVideo")
    public List<Video> getAllVideo() {
        List<Video> Videos = videoService.getAllVideo();

        return Videos;
    }
}
