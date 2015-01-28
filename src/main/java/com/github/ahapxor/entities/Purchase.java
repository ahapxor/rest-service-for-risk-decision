package com.github.ahapxor.entities;

public class Purchase {
    final private String email;
    final private String firstName;
    final private String lastName;
    final private Integer amount;

    public Purchase(String email, String firstName, String lastName, Integer amount) {
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
