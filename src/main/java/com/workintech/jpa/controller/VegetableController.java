package com.workintech.jpa.controller;

import com.workintech.jpa.entity.Vegetable;
import com.workintech.jpa.services.VegetableService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/vegetables")
public class VegetableController {
    private VegetableService vegetableService;
    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @PostMapping("/")
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/")
    public List<Vegetable> findAll(){
        return vegetableService.findAll();
    }

    @GetMapping("/{id}")
    public Vegetable find(@Positive @PathVariable Integer id){
        return vegetableService.find(id);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable Integer id){
        return vegetableService.delete(id);
    }

    @GetMapping("/asc")
    public List<Vegetable> sortByPriceAsc(){
        return vegetableService.sortByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> sortByPriceDesc(){
        return vegetableService.sortByPriceDesc();
    }

    @GetMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name){
        return vegetableService.searchByName(name);
    }
}
