package com.cookguide.database.cookAPI.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "preference")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(name = "feeding", length = 100, nullable = false)
    private String feeding;

    @Column(name = "tastes", columnDefinition = "json", nullable = false)
    private String tastes;

    @Column(name = "allerges", columnDefinition = "json", nullable = false)
    private String allerges;

    @Column(name = "needs", columnDefinition = "json", nullable = false)
    private String needs;


}

/*
CREATE TABLE preferences (
    uid int  NOT NULL,
    feeding varchar(100)  NOT NULL,
    tastes json  NOT NULL,
    allerges json  NOT NULL,
    needs json  NOT NULL,
    CONSTRAINT preferences_pk PRIMARY KEY (uid)
);


 */
