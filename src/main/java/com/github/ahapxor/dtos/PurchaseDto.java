package com.github.ahapxor.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseDto {
    final private String email;
    final private String firstName;
    final private String lastName;
    final private Integer amount;

    @JsonCreator public PurchaseDto(@JsonProperty("email") String email,
                                    @JsonProperty("first_name") String firstName,
                                    @JsonProperty("last_name") String lastName,
                                    @JsonProperty("amount") Integer amount) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAmount() {
        return amount;
    }
}
