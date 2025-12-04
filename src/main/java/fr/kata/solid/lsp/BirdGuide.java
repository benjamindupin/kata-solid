package fr.kata.solid.lsp;

/**
 * Guide qui gère explicitement les cas au lieu de s'appuyer sur le polymorphisme.
 */
public class BirdGuide {

    public String describeMove(Bird bird) {
        if (bird instanceof Penguin penguin) {
            return "Manchot : " + penguin.swim();
        }
        return "Oiseau : " + bird.fly();
    }
}
