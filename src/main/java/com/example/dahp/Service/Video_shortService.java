package com.example.dahp.Service;

import com.example.dahp.Entity.Video_short;
import com.example.dahp.Repository.Video_shortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Video_shortService {

    @Autowired
    private Video_shortRepository video_shortRepository;

    public List<Video_short> getAllVideo_short() {
        List<Video_short> videos = video_shortRepository.findAllByOrderByIdDesc();
        return videos;
    }
}
