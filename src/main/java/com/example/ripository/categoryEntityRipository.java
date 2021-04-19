package com.example.ripository;

import com.example.entity.PullDownCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryEntityRipository extends JpaRepository<PullDownCategory, Long> {
}
