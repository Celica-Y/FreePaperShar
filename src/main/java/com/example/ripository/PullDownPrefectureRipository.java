package com.example.ripository;

import com.example.entity.prefectureEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PullDownPrefectureRipository extends JpaRepository<prefectureEntity, Long>{
    
}
