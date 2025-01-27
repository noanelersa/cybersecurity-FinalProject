package datavault.server.services;

import datavault.server.dto.EventDTO;
import datavault.server.exceptions.AclViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class EventsService {
    private final Random random = new Random();

    public void validateEvent(EventDTO event) throws AclViolationException {
        if (random.nextInt() % 2 == 0) {
            throw new AclViolationException(event);
        }
    }
}
