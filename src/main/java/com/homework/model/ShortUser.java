package com.homework.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ShortUser {
    @Pattern(regexp = "[a-zA-Z]{1,30}")
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]{1,30}")
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
