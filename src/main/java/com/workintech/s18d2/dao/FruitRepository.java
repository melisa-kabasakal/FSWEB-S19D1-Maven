package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository <Fruit, Long> {

    @Query(value="SELECT f.id, f.fruit_name, f.fruit_price, f.fruit_type FROM fsweb.fruit f ORDER BY f.fruit_price DESC", nativeQuery = true)
    List<Fruit> findByPriceDesc();

    @Query(value="SELECT f.id, f.fruit_name, f.fruit_price, f.fruit_type FROM fsweb.fruit f ORDER BY f.fruit_price ASC", nativeQuery = true)
    List<Fruit> findByPriceAsc();

    @Query(value="SELECT f.id, f.fruit_name, f.fruit_price, f.fruit_type FROM fsweb.fruit f WHERE f.fruit_name LIKE %:name%", nativeQuery = true)
    List<Fruit> searchByName(String name);
}
