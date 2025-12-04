package fr.kata.solid.isp;

import java.util.ArrayList;
import java.util.List;

/**
 * Orchestre une journée en gérant au cas par cas les exceptions.
 */
public class WorkDayManager {

    public List<String> runDay(Worker worker) {
        List<String> log = new ArrayList<>();
        log.add(worker.work());
        try {
            log.add(worker.eat());
        } catch (UnsupportedOperationException e) {
            log.add("pause repas ignorée");
        }
        log.add(worker.sleep());
        return log;
    }
}
