package by.zabavskiy.repository;

import by.zabavskiy.domain.Equipment;

import java.util.List;

public interface EquipmentRepository {
    List<Equipment> findUserEquipment(Long userId);
}