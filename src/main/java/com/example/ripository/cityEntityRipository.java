package com.example.ripository;

import java.util.List;

import com.example.entity.cityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cityEntityRipository extends JpaRepository<cityEntity, Long>{
    public List<cityEntity> findByPrefIdId(long prefIdId);
}
