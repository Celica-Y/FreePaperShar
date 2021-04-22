package com.example.repository;

import java.util.List;

import com.example.entity.cityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cityEntityRepository extends JpaRepository<cityEntity, Long>{
    public List<cityEntity> findByPrefIdId(long prefIdId);
}
