package fr.kata.solid.lsp;

public class Bird {
    public String move() {
        return fly();
    }

    public String fly() {
        return "je vole";
    }
}
