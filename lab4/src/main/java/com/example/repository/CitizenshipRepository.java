package com.example.repository;

import com.example.entity.Citizenship;
import com.example.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenshipRepository extends JpaRepository<Citizenship, Long> {
    boolean existsByName(String name);
}
