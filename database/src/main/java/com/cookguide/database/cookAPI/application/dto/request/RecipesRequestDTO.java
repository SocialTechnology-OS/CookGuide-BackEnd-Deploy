package com.cookguide.database.cookAPI.application.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipesRequestDTO {

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "image is mandatory")
    private String image;

    @NotBlank(message = "preparation is mandatory")
    private String preparation;

    @NotBlank(message = "time is mandatory")
    private String time;

    @NotBlank(message = "servings is mandatory")
    private String servings;

    @NotBlank(message = "author is mandatory")
    private int authorId;
}
