package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "fruit", schema = "fsweb")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="fruit_name")
    private String name;

    @Column(name = "fruit_price")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType fruitType;
}
