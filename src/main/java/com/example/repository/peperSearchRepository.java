package com.example.repository;

import java.util.List;

import com.example.entity.PaperTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface peperSearchRepository extends JpaRepository<PaperTable, Long>{
    public List<PaperTable> findByPaperNameContaining(String PaperName);
    public List<PaperTable> findByPaperNameAndCategory(String PaperName, String category);
    public List<PaperTable> findByPrefectures(String prefectures);
    public List<PaperTable> findByPaperName(String PaperName);
    public List<PaperTable> findByCategory(String category);
}
