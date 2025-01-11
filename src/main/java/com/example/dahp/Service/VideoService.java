package com.example.dahp.Service;

import com.example.dahp.Entity.Video;
import com.example.dahp.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    public List<Video> getAllVideo() {
        List<Video> videos = videoRepository.findAll();
        return videos;
    }
}
