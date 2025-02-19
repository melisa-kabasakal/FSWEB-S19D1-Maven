package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitsDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getFruitsByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit saveFruit(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/{id}")
    public Fruit getFruitById(@PathVariable Long id) {
        return fruitService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Long id) {
        fruitService.delete(id);
    }
}
