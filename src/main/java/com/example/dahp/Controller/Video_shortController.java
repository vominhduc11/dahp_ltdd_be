package com.example.dahp.Controller;

import com.example.dahp.Entity.Video_short;
import com.example.dahp.Service.Video_shortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Video_shortController {
    @Autowired
    private Video_shortService video_shortService;

    @GetMapping(value = "/getAllVideo_short")
    public List<Video_short> getAllVideo() {
        List<Video_short> Videos = video_shortService.getAllVideo_short();

        return Videos;
    }
}
