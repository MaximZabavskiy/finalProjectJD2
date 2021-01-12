package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Equipment;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentSpringDataRepository extends JpaRepository<Equipment, Long> {

    @Cacheable("equipment")
    @Query(value = "select e from Equipment e")
    List<Equipment> findAllWithCache();

    @Query(value = "select e from Equipment e order by e.id")
    List<Equipment> findAllEquipment();

    @Query(value = "select e from Equipment e where e.id = :id ")
    Equipment findEquipmentById(@Param("id") Long id);

}
