package fr.kata.solid.ocp;

import java.util.Objects;

public record CustomerProfile(String name, CustomerType type) {
    public CustomerProfile {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(type, "type");
    }
}
