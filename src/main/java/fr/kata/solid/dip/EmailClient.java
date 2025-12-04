package fr.kata.solid.dip;

public class EmailClient {
    public String send(String address, String message) {
        return "email->" + address + " : " + message;
    }
}
