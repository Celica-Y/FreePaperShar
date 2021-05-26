package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.entity.userData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRipository extends JpaRepository<userData, Long>{
    public List<userData> findByPassword(String password);
}
