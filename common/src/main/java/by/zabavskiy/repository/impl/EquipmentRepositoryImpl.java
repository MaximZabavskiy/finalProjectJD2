package by.zabavskiy.repository.impl;

import by.zabavskiy.domain.Equipment;
import by.zabavskiy.repository.EquipmentRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
@Primary
@Log4j2
public class EquipmentRepositoryImpl implements EquipmentRepository {

    private SessionFactory sessionFactory;

    public EquipmentRepositoryImpl(SessionFactory sessionFactory/*, EntityManager entityManager*/) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Equipment> findUserEquipment(Long userId) {
        return Collections.emptyList();
    }
}