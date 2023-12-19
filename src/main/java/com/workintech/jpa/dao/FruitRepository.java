package com.workintech.jpa.dao;

import com.workintech.jpa.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Integer> {
    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> sortByPriceAsc();
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> sortByPriceDesc();
    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(String name);

}
