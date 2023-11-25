package com.cookguide.database.cookAPI.application.dto.response;

public class AuthorDetailDTO {
    private int id;
    private String firstName;
    private String lastName;

    public AuthorDetailDTO() {
    }

    // Constructor con todos los campos
    public AuthorDetailDTO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
