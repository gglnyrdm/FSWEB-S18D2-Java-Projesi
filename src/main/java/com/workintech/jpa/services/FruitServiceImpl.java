package com.workintech.jpa.services;

import com.workintech.jpa.dao.FruitRepository;
import com.workintech.jpa.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;
    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit find(Integer id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if (fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        return null;//TODO
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Integer id) {
        Fruit fruit = find(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> sortByPriceAsc() {
        return fruitRepository.sortByPriceAsc();
    }

    @Override
    public List<Fruit> sortByPriceDesc() {
        return fruitRepository.sortByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
