package fr.kata.solid.dip;

/**
 * Dépend directement de clients concrets plutôt que d'abstractions.
 */
public class NotificationService {

    private final EmailClient emailClient = new EmailClient();
    private final SmsClient smsClient = new SmsClient();

    public String notifyUser(User user, String message) {
        StringBuilder builder = new StringBuilder();
        if (user.wantsEmail()) {
            builder.append(emailClient.send(user.email(), message));
        }
        if (user.wantsSms()) {
            if (!builder.isEmpty()) {
                builder.append(System.lineSeparator());
            }
            builder.append(smsClient.send(user.phoneNumber(), message));
        }
        return builder.toString();
    }
}
