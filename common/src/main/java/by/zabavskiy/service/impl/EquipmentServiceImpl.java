package by.zabavskiy.service.impl;

import by.zabavskiy.domain.Calendar;
import by.zabavskiy.domain.Equipment;
import by.zabavskiy.repository.impl.CalendarSpringDataRepository;
import by.zabavskiy.repository.impl.EquipmentSpringDataRepository;
import by.zabavskiy.service.CalendarService;
import by.zabavskiy.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentSpringDataRepository equipmentSpringDataRepository;

    public EquipmentServiceImpl(EquipmentSpringDataRepository equipmentSpringDataRepository) {
        this.equipmentSpringDataRepository = equipmentSpringDataRepository;
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentSpringDataRepository.findAllWithCache();
    }
}
