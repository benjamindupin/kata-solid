package fr.kata.solid.srp;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Immutable order line used by the receipt service.
 */
public record OrderLine(String description, int quantity, BigDecimal unitPrice) {

    public OrderLine {
        Objects.requireNonNull(description, "description");
        Objects.requireNonNull(unitPrice, "unitPrice");
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        if (unitPrice.signum() < 0) {
            throw new IllegalArgumentException("unitPrice must be positive");
        }
    }
}
