package com.example.dahp.Service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.dahp.Entity.Video_short;
import com.example.dahp.Repository.Video_shortRepository;

@Service
public class VideoUploadService {
    @Autowired
    private Video_shortRepository video_shortRepository;

    @Autowired
    private Cloudinary cloudinary;

    public String uploadVideo(MultipartFile file) throws IOException {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "resource_type", "video", // Định nghĩa loại file là video
                "folder", "videos_short" // Định nghĩa thư mục đích trong Cloudinary
        ));

        try {
            Video_short video = new Video_short();
            // Lấy URL đầy đủ
            String fullUrl = uploadResult.get("url").toString();
            // Lấy phần đuôi sau dấu '/' cuối cùng
            String fileName = fullUrl.substring(fullUrl.lastIndexOf("/") + 1);
            video.setLink(fileName); // Gán phần đuôi vào video.setLink
            video_shortRepository.save(video); // Lưu thông tin vào cơ sở dữ liệu
        } catch (Exception e) {
            // TODO: handle exception
        }

        return uploadResult.get("url").toString(); // Trả về URL đầy đủ của video đã upload
    }

}
