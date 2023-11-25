package com.cookguide.database.cookAPI.application.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDTO {
    @NotBlank(message = "firstName is mandatory")
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    private String lastName;

    @NotBlank(message = "email is mandatory")
    private String email;

    @NotBlank(message = "user is mandatory")
    private String user;

    @NotBlank(message = "password is mandatory")
    private String password;

    @NotBlank(message = "type is mandatory")
    private String type;

    @NotBlank(message = "birthday is mandatory")
    private LocalDate birthday;

    @NotBlank(message = "phone is mandatory")
    private String phone;

    @NotBlank(message = "DNI is mandatory")
    private Long DNI;

    @NotBlank(message = "gender is mandatory")
    private String gender;

    @NotBlank(message = "diet is mandatory")
    private String diet;

    @NotBlank(message = "picture is mandatory")
    private String picture;

    @Column(name = "height", nullable = false)
    private Float height;

    @Column(name = "weight", nullable = false)
    private Float weight;
}
