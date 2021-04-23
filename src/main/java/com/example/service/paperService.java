package com.example.service;

import java.util.List;

import com.example.entity.PaperTable;
import com.example.repository.PaperTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class paperService {
    
    @Autowired
    PaperTableRepository ptrepository;

    public List<PaperTable> search(
        long id, String PaperName,
        String prefectures, String city, 
        String category,String year,
        String month, String comment) {

        List<PaperTable> result = ptrepository.findAll();
        return result;
    }
}
