package app.service;

import app.domain.Instructor;
import app.domain.InstructorBusyness;
import app.dto.InstructorBusynessDTO;
import app.repository.InstructorBusynessRepository;
import app.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InstructorBusynessServiceImpl implements InstructorBusynessService{

    @Autowired
    private InstructorBusynessRepository instructorBusynessRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public InstructorBusynessDTO addBusynessInterval(InstructorBusynessDTO interval) {
        Instructor instructor = instructorRepository.findById(interval.getInstructorId()).orElseGet(null);
        instructorBusynessRepository.save(new InstructorBusyness(interval.getStartInterval(), interval.getEndInterval(), instructor));
        return interval;
    }
}
