package com.cookguide.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long uid;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "numPortions", nullable = false)
    private int numPortions;

    @Column(name = "description")
    private String description;

}
