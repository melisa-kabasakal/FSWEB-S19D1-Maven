package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit save(Fruit fruit);
    List<Fruit> findAll();
    Fruit getById(Long id);
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);

    Fruit delete(Long id);
}
