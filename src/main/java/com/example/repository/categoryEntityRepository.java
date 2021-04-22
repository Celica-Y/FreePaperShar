package com.example.repository;

import com.example.entity.PullDownCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryEntityRepository extends JpaRepository<PullDownCategory, Long> {
}
