package fr.kata.solid.dip;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotificationServiceTest {

    private final NotificationService service = new NotificationService();

    @Test
    void sends_email_and_sms_based_on_preferences() {
        User user = new User("Sam", "sam@example.test", "+123", true, true);

        String result = service.notifyUser(user, "Hello");

        assertThat(result).contains("email->sam@example.test : Hello")
                .contains("sms->+123 : Hello");
    }

    @Test
    void can_skip_channels() {
        User emailOnly = new User("Kim", "kim@example.test", "+999", true, false);

        String result = service.notifyUser(emailOnly, "Hi");

        assertThat(result).isEqualTo("email->kim@example.test : Hi");
    }
}
