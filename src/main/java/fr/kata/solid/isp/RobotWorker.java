package fr.kata.solid.isp;

/**
 * Implémentation forcée d'une interface trop large.
 */
public class RobotWorker implements Worker {
    @Override
    public String work() {
        return "assemble";
    }

    @Override
    public String eat() {
        throw new UnsupportedOperationException("Un robot ne mange pas");
    }

    @Override
    public String sleep() {
        return "passe en veille";
    }
}
