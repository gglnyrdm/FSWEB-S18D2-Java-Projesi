package com.workintech.jpa.services;

import com.workintech.jpa.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findAll();
    Vegetable find(Integer id);
    Vegetable save(Vegetable vegetable);
    Vegetable delete(Integer id);
    List<Vegetable> sortByPriceAsc();
    List<Vegetable> sortByPriceDesc();
    List<Vegetable> searchByName(String name);
}
