package com.example.service;

import java.io.Serializable;
import java.util.List;

public interface paperDao extends Serializable {
    public List search(String PaperName,String prefectures,String city,String category,int year, int month);
}
