package datavault.server.controllers;

import datavault.server.dto.EventDTO;
import datavault.server.enums.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@Slf4j
public class EventsController {

    @PostMapping
    public ResponseEntity<String> newEvent(@RequestBody EventDTO event) {
        log.info("Event was captured, {} tried to {} file with id: '{}'", event.user(), event.action(), event.fileID());

        if (event.fileID().isEmpty() || event.action() == Action.MANAGE) {
            log.warn("Blocking {} action that was made by {}", event.action(), event.user());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok().build();
    }
}
