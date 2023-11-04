package com.cookguide.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Health_info {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(name = "imc", nullable = false)
    private int imc;

    @Column(name = "weight", columnDefinition = "FLOAT(5,2)", nullable = false)
    private float weight;

    @Column(name = "height", columnDefinition = "FLOAT(5,2)", nullable = false)
    private float height;
}
