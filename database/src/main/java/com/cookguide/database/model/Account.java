package com.cookguide.database.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long uid;

    @Column( name = "firstName", length = 100, nullable = false)
    private String firstName;

    @Column( name = "lastName", length = 100, nullable = false)
    private String lastName;

    @Column( name = "userEmail", length = 100, nullable = false)
    private String userEmail;

    @Column( name = "userPassword", length = 100, nullable = false)
    private String userPassword;

    @Column( name = "userType", nullable = false)
    private boolean userType;

    @Column(name = "birthday", nullable = false)
    private LocalDateTime birthday;

    @Column(name = "DNI", nullable= false)
    private int DNI;
    /*
    @OneToOne
    @JoinColumn(name = "healthId", nullable = false
    , foreignKey = @ForeignKey(name = "fkHealthID"))
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    private Health_info healthInfo;

    @OneToOne
    @JoinColumn(name = "PreferenceId", nullable = false
            , foreignKey = @ForeignKey(name = "fkPreferenceId"))
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    private Preference preference;
    */

}
