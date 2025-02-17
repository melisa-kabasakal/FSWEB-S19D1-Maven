package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FruitServiceImpl implements FruitService {
    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        return fruit.orElseThrow(() -> new PlantException("Fruit not found with id: " + id));  // Optional'ı doğrudan Fruit'e çeviriyoruz
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.findByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.findByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(Long id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if (fruit.isPresent()) {
            fruitRepository.deleteById(id);
            return fruit.get();
        }
        throw new PlantException("Fruit not found with id: " + id);
    }

}
