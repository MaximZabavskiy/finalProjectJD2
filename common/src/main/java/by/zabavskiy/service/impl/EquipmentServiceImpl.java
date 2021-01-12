package by.zabavskiy.service.impl;

import by.zabavskiy.domain.Equipment;
import by.zabavskiy.repository.impl.EquipmentSpringDataRepository;
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
        return equipmentSpringDataRepository.findAllEquipment();
    }

    @Override
    public List<Equipment> findAllWithCache() {
        return equipmentSpringDataRepository.findAllWithCache();
    }

    @Override
    public Equipment findById(Long equipmentId) {
        return equipmentSpringDataRepository.findEquipmentById(equipmentId);
    }

    @Override
    public Equipment save(Equipment equipment) {
        return equipmentSpringDataRepository.save(equipment);
    }

    @Override
    public Equipment update(Equipment equipment) {
        return equipmentSpringDataRepository.save(equipment);
    }

    @Override
    public void deleteById(Long id) {
        equipmentSpringDataRepository.deleteById(id);
    }
}
