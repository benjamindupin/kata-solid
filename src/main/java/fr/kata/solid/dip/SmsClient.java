package fr.kata.solid.dip;

public class SmsClient {
    public String send(String number, String message) {
        return "sms->" + number + " : " + message;
    }
}
