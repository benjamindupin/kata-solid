package fr.kata.solid.srp;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * Service volontairement surchargé de responsabilités pour illustrer SRP.
 */
public class ReceiptService {

    private static final BigDecimal VAT_RATE = new BigDecimal("0.20");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String printAndSave(List<OrderLine> lines, Path outputFile) {
        Objects.requireNonNull(lines, "lines");
        Objects.requireNonNull(outputFile, "outputFile");

        String receipt = buildReceipt(lines);
        logToConsole(receipt);
        persist(receipt, outputFile);
        return receipt;
    }

    private String buildReceipt(List<OrderLine> lines) {
        StringBuilder builder = new StringBuilder();
        builder.append("=== RECAP COMMANDE ===\n");
        builder.append("Date : ").append(LocalDateTime.now().format(FORMATTER)).append("\n\n");

        BigDecimal total = BigDecimal.ZERO;
        for (OrderLine line : lines) {
            BigDecimal lineTotal = line.unitPrice().multiply(BigDecimal.valueOf(line.quantity()));
            total = total.add(lineTotal);
            builder.append(line.quantity())
                    .append(" x ")
                    .append(line.description())
                    .append(" = ")
                    .append(lineTotal.setScale(2, RoundingMode.HALF_UP))
                    .append("€\n");
        }

        BigDecimal vat = total.multiply(VAT_RATE).setScale(2, RoundingMode.HALF_UP);
        builder.append("TVA (20%) : ").append(vat).append("€\n");
        builder.append("TOTAL : ").append(total.add(vat).setScale(2, RoundingMode.HALF_UP)).append("€\n");
        return builder.toString();
    }

    private void logToConsole(String receipt) {
        System.out.println(receipt);
    }

    private void persist(String receipt, Path outputFile) {
        try {
            Path parent = outputFile.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Files.writeString(outputFile, receipt);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
