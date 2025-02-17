package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Workintech/fruits")
public class FruitController {
    private FruitService fruitService;

    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }


    @GetMapping
    public List<Fruit> getByFruitPriceAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getFruitById(@PathVariable Long id) {
        return fruitService.getById(id);
    }

    @PostMapping
    public Fruit saveOrUpdateFruit(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/name/{name}")
    public List<Fruit> getFruitsByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        fruitService.delete(id);
    }
}
