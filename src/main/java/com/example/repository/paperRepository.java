package com.example.repository;

import com.example.entity.PaperTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paperRepository extends JpaRepository<PaperTable, Long>{
}
