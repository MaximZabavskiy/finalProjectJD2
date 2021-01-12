package by.zabavskiy.service;

import by.zabavskiy.domain.Equipment;

import java.util.List;

public interface EquipmentService {

    List<Equipment> findAll();

    List<Equipment> findAllWithCache();

    Equipment findById(Long equipmentId);

    Equipment save(Equipment equipment);

    Equipment update(Equipment equipment);

    void deleteById(Long id);
}
