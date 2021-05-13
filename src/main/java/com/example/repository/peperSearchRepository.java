package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.entity.PaperTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface peperSearchRepository extends JpaRepository<PaperTable, Long>{
    public List<PaperTable> findByPaperNameContaining(String paperName);
    public List<PaperTable> findByPaperNameAndCategory(String paperName, String category);
    public List<PaperTable> findByPrefectures(String prefectures);
    public List<PaperTable> findByPaperName(String paperName);
    public List<PaperTable> findByCategory(String category);
    public List<PaperTable> findByPrefecturesAndPaperNameContaining(String prefectures, String paperName);
    public List<PaperTable> findByPrefecturesAndCategory(String prefectures, String category);
    public List<PaperTable> findByCategoryAndPaperNameContaining(String category, String paperName);
    public List<PaperTable> findByPrefecturesAndCategoryAndPaperName(String prefectures, String category, String paperName);
}
