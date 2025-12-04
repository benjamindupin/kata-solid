package fr.kata.solid.dip;

import java.util.Objects;

public record User(String name, String email, String phoneNumber, boolean wantsEmail, boolean wantsSms) {
    public User {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(email, "email");
        Objects.requireNonNull(phoneNumber, "phoneNumber");
    }
}
