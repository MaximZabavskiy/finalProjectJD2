package by.zabavskiy.service.impl;

import by.zabavskiy.domain.Program;
import by.zabavskiy.repository.impl.ProgramSpringDataRepository;
import by.zabavskiy.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    private ProgramSpringDataRepository programSpringDataRepository;

    public ProgramServiceImpl(ProgramSpringDataRepository programSpringDataRepository) {
        this.programSpringDataRepository = programSpringDataRepository;
    }

    @Override
    public List<Program> findAll() {
        return programSpringDataRepository.findAllPrograms();
    }

    @Override
    public List<Program> findAllWithCache() {
        return programSpringDataRepository.findAllWithCache();
    }

    @Override
    public Program findById(Long programId) {
        return programSpringDataRepository.findProgramById(programId);
    }

    @Override
    public Program save(Program program) {
        return programSpringDataRepository.save(program);
    }

    @Override
    public Program update(Program program) {
        return programSpringDataRepository.save(program);
    }

    @Override
    public void deleteById(Long id) {
        programSpringDataRepository.deleteProgramById(id);
    }

}
