package by.zabavskiy.service.impl;

import by.zabavskiy.domain.Perfomance;
import by.zabavskiy.repository.impl.PerfomanceSpringDataRepository;
import by.zabavskiy.service.PerfomanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfomanceServiceImpl implements PerfomanceService {

    private PerfomanceSpringDataRepository perfomanceSpringDataRepository;

    public PerfomanceServiceImpl(PerfomanceSpringDataRepository perfomanceSpringDataRepository) {
        this.perfomanceSpringDataRepository = perfomanceSpringDataRepository;
    }

    @Override
    public List<Perfomance> findAll() {
        return perfomanceSpringDataRepository.findAllWithCache();
    }
}
