package com.workintech.jpa.controller;

import com.workintech.jpa.entity.Fruit;
import com.workintech.jpa.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruits")
public class FruitController {

    private FruitService fruitService;
    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping("/")
    public List<Fruit> findAll(){
        return fruitService.findAll();
    }

    @GetMapping("/{id}")
    public Fruit find(@Positive @PathVariable Integer id){
        return fruitService.find(id);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable Integer id){
        return fruitService.delete(id);
    }

    @GetMapping("/asc")
    public List<Fruit> sortByPriceAsc(){
        return fruitService.sortByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> sortByPriceDesc(){
        return fruitService.sortByPriceDesc();
    }

    @GetMapping("/{name}")
    public List<Fruit> searchByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }
}
