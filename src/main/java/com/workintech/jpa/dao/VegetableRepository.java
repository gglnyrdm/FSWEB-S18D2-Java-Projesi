package com.workintech.jpa.dao;

import com.workintech.jpa.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Integer> {
    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> sortByPriceAsc();
    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> sortByPriceDesc();
    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
