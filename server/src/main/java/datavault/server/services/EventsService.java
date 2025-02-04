package datavault.server.services;

import datavault.server.Repository.FileRepository;
import datavault.server.dto.EventDTO;
import datavault.server.entities.FileEntity;
import datavault.server.entities.FileEntity;
import datavault.server.exceptions.AclViolationException;
import datavault.server.Repository.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EventsService {

    private final FileRepository fileRepository;

    // ✅ Inject FileRepository using constructor injection
    public EventsService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void validateEvent(EventDTO event) throws AclViolationException {
        // ✅ Use the injected repository instance
        Optional<FileEntity> file = fileRepository.findByFileId(event.fileID());

        if (file.isEmpty()) {
            log.warn("Validation failed: File ID '{}' does not exist in the database.", event.fileID());
            throw new AclViolationException(event);
        }

        log.info("Validation passed: File ID '{}' exists. Processing event...", event.fileID());
    }
}
