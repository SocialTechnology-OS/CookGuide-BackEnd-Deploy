package com.cookguide.database.cookAPI.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recipes")
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column (name = "preparation", nullable = false)
    private String preparation;

    @Column (name = "time", nullable = false)
    private int time;

    @Column (name = "servings", nullable = false)
    private int servings;

    public int getUid() {
        return uid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
