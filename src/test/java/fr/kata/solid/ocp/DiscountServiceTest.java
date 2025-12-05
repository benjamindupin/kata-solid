package fr.kata.solid.ocp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountServiceTest {

    private final DiscountService service = new DiscountService();

    @Test
    void apply_discount_for_known_customer_types() {
        CustomerProfile standard = new CustomerProfile("Paul", CustomerType.STANDARD);
        CustomerProfile student = new CustomerProfile("Ana", CustomerType.STUDENT);
        CustomerProfile vip = new CustomerProfile("Léa", CustomerType.VIP);

        assertThat(service.applyDiscount(standard, new BigDecimal("50"))).isEqualByComparingTo("50.00");
        assertThat(service.applyDiscount(student, new BigDecimal("100"))).isEqualByComparingTo("90.00");
        assertThat(service.applyDiscount(vip, new BigDecimal("80"))).isEqualByComparingTo("64.00");
    }
}
