package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Equipment;
import by.zabavskiy.domain.Perfomance;
import by.zabavskiy.repository.EquipmentRepository;
import by.zabavskiy.repository.PerfomanceRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
public class PerfomanceRepositoryImpl implements PerfomanceRepository {

    private static final Logger log = Logger.getLogger(PerfomanceRepositoryImpl.class);

    @Override
    public List<Perfomance> findUserPerfomance(Long userId) {
        return Collections.emptyList();
    }
}