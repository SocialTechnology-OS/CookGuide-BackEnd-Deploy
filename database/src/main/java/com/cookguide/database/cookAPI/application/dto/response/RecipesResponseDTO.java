package com.cookguide.database.cookAPI.application.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipesResponseDTO {

    private int uid;

    private String name;

    private String image;

    private String preparation;

    private String time;

    private String servings;

    private List<String> ingredients;

    private int authorId;
}
