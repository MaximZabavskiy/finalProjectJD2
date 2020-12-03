package by.zabavskiy.domain.hibernate;

import by.zabavskiy.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {
        "calendar"
})
@ToString(exclude = {
        "calendar"
})
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "m_equipment")

public class HibernateEquipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ClothesName clothes = ClothesName.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private ShoesName shoes = ShoesName.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private BeverageName beverage = BeverageName.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private CleansersName cleansers = CleansersName.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @JsonIgnoreProperties("programs")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "l_calendar_equipment",
            joinColumns = {@JoinColumn(name = "calendar_id")},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id")}
    )
    private Set<HibernateCalendar> calendar = Collections.emptySet();
}
