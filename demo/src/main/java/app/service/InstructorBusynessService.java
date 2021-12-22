package app.service;

import app.domain.InstructorBusyness;
import app.dto.InstructorBusynessDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface InstructorBusynessService {
    InstructorBusynessDTO addBusynessInterval(InstructorBusynessDTO interval);
}
