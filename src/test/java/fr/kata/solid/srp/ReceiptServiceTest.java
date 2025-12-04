package fr.kata.solid.srp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiptServiceTest {

    private final ReceiptService service = new ReceiptService();

    @TempDir
    Path tempDir;

    @Test
    void generate_receipt_and_persist_file() throws Exception {
        List<OrderLine> lines = List.of(
                new OrderLine("café", 2, new BigDecimal("2.50")),
                new OrderLine("cookie", 1, new BigDecimal("3.10"))
        );
        Path file = tempDir.resolve("receipt.txt");

        String receipt = service.printAndSave(lines, file);

        assertThat(receipt).contains("café").contains("cookie").contains("TOTAL");
        assertThat(Files.readString(file)).isEqualTo(receipt);
    }
}
