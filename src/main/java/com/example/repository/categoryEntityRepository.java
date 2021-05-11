package com.example.repository;

import com.example.entity.PullDownCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryEntityRepository extends JpaRepository<PullDownCategory, Long> {
}
