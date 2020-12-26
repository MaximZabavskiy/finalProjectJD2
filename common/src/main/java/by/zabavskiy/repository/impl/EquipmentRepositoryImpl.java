package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Equipment;
import by.zabavskiy.repository.EquipmentRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
public class EquipmentRepositoryImpl implements EquipmentRepository {

    private static final Logger log = Logger.getLogger(EquipmentRepositoryImpl.class);

    @Override
    public List<Equipment> findUserEquipment(Long userId) {
        return Collections.emptyList();
    }
}