package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.services.VegetableServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getByVegetablePriceAsc(){
        return vegetableService.findByPriceAsc();
    }

    @GetMapping("/{id}")
    public Optional<Vegetable> getVegetableById(@PathVariable Long id){
        return vegetableService.findById(id);
    }


    @PostMapping
    public Vegetable saveOrUpdateVegetable(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{id}")
    public List<Vegetable> getVegetablesByName(@PathVariable String name){
        return vegetableService.findByName(name);
    }
    @DeleteMapping("/{id}")
    public void deleteVegetable(@PathVariable Long id){
        vegetableService.delete(id);
    }
}
