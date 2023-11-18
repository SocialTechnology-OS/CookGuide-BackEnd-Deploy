package com.cookguide.database.cookAPI.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDTO {
    @NotBlank(message = "firstName is mandatory")
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    private String lastName;

    @NotBlank(message = "userEmail is mandatory")
    private String userEmail;

    @NotBlank(message = "userPassword is mandatory")
    private String userPassword;

    @NotBlank(message = "userType is mandatory")
    private boolean userType;

    @NotBlank(message = "birthday is mandatory")
    private String birthday;

    @NotBlank(message = "phone is mandatory")
    private String phone;

    @NotBlank(message = "DNI is mandatory")
    private int DNI;

    @NotBlank(message = "gender is mandatory")
    private String gender;

    @NotBlank(message = "diet is mandatory")
    private String diet;

    @NotBlank(message = "picture is mandatory")
    private String picture;

}
