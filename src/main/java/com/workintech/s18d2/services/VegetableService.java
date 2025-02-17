package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;
import java.util.Optional;

public interface VegetableService {
    Vegetable save(Vegetable vegetable);
    List<Vegetable> findAll();
    Optional<Vegetable> findById(Long id);

    List<Vegetable> findByPriceDesc();
    List<Vegetable> findByPriceAsc();
    List<Vegetable> findByName(String name);

    void delete(Long id);
}
