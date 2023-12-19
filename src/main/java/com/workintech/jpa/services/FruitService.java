package com.workintech.jpa.services;

import com.workintech.jpa.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAll();
    Fruit find(Integer id);
    Fruit save(Fruit fruit);
    Fruit delete(Integer id);
    List<Fruit> sortByPriceAsc();
    List<Fruit> sortByPriceDesc();
    List<Fruit> searchByName(String name);
}
