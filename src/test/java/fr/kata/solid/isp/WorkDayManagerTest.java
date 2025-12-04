package fr.kata.solid.isp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WorkDayManagerTest {

    private final WorkDayManager manager = new WorkDayManager();

    @Test
    void runs_day_for_human() {
        List<String> log = manager.runDay(new HumanWorker());

        assertThat(log).containsExactly("travaille", "mange", "dort");
    }

    @Test
    void runs_day_for_robot_even_if_eat_is_unsupported() {
        List<String> log = manager.runDay(new RobotWorker());

        assertThat(log).containsExactly("assemble", "pause repas ignorée", "passe en veille");
    }
}
