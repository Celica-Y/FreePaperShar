package com.example.ripository;

import java.util.List;

import com.example.entity.PullDownCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryEntityRipository extends JpaRepository<PullDownCategory, Long> {
    // public List<PullDownCategory> findByCode();
    // public List<PullDownCategory> findBycategoryName(String categoryName);
    // public List<PullDownCategory> findByName();
}
