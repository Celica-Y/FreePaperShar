package com.example.ripository;

import com.example.entity.PaperTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperTableRipository extends JpaRepository<PaperTable, Long>{
    
}
