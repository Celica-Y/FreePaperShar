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
        String prefectures
        // String city, 
        // String category, 
        // int year,
        // int month
        ) {

            List<PaperTable> result = ptrepository.findAll();
            return result;
        }
}
