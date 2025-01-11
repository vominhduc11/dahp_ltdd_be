package com.example.dahp.Repository;

import com.example.dahp.Entity.Video_short;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Video_shortRepository extends JpaRepository<Video_short, Long> {

    List<Video_short> findAllByOrderByIdDesc();
}
