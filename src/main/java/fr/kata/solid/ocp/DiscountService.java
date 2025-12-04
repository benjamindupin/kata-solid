package fr.kata.solid.ocp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Exemple volontairement fermé à l'extension : toute nouvelle règle nécessite de modifier ce switch.
 */
public class DiscountService {

    public BigDecimal applyDiscount(CustomerProfile customer, BigDecimal price) {
        Objects.requireNonNull(customer, "customer");
        Objects.requireNonNull(price, "price");

        return switch (customer.type()) {
            case STUDENT -> percentage(price, 10);
            case VIP -> percentage(price, 20);
            case STANDARD -> price.setScale(2, RoundingMode.HALF_UP);
        };
    }

    private BigDecimal percentage(BigDecimal price, int percent) {
        return price.multiply(BigDecimal.valueOf(100 - percent))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
