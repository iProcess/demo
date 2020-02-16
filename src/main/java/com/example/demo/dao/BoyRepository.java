package com.example.demo.dao;

import com.example.demo.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy, Integer> {

    List<Boy> findBySex(String sex);
}
