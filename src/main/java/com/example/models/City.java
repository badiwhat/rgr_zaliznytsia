package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data // Це Lombok, він сам створить геттери та сеттери
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}