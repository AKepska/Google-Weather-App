package com.example.weatherApi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weatherApi.model.domain.DBResult;

public interface DBResultRepository extends JpaRepository<DBResult, Integer> {

}
