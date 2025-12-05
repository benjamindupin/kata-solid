package fr.kata.solid.lsp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BirdGuideTest {

    private final BirdGuide guide = new BirdGuide();

    @Test
    void handles_generic_bird() {
        Bird bird = new Bird();

        String description = guide.describeMove(bird);

        assertThat(description).isEqualTo("Oiseau : je vole");
    }

    @Test
    void handles_penguin_without_crashing() {
        Bird penguin = new Penguin();

        String description = guide.describeMove(penguin);

        assertThat(description).isEqualTo("Manchot : je nage");
    }
}
