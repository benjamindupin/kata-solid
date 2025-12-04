package fr.kata.solid.lsp;

/**
 * Penguin ne peut pas voler mais hérite quand même de Bird.
 */
public class Penguin extends Bird {

    @Override
    public String fly() {
        throw new UnsupportedOperationException("Les manchots ne volent pas");
    }

    public String swim() {
        return "je nage";
    }
}
