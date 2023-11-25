package com.cookguide.database.cookAPI.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name = "firstName", length = 100, nullable = false)
    private String firstName;

    @Column( name = "lastName", length = 100, nullable = false)
    private String lastName;

    @Column( name = "email", length = 100, nullable = false)
    private String email;

    @Column( name = "user", length = 100, nullable = false)
    private String user;

    @Column( name = "password", length = 100, nullable = false)
    private String password;

    @Column( name = "type", nullable = false)
    private String type;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "DNI", nullable= false)
    private Long DNI;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "diet", nullable = false)
    private String diet;

    @Column(name = "picture", nullable = false)
    private String picture;

    @Column(name = "height", nullable = false)
    private Float height;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Recipes> recipes = new HashSet<>();

}
