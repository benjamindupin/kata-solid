package fr.kata.solid.isp;

public class HumanWorker implements Worker {
    @Override
    public String work() {
        return "travaille";
    }

    @Override
    public String eat() {
        return "mange";
    }

    @Override
    public String sleep() {
        return "dort";
    }
}
