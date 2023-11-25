package com.cookguide.database.cookAPI.application.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String user;
    private String password;
    private String type;
    private LocalDate birthday;
    private String phone;
    private Long DNI;
    private String gender;
    private String diet;
    private String picture;
    private Float height;
    private Float weight;

}
