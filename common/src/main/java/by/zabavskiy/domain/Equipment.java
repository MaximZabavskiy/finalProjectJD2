package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.BeverageName;
import by.zabavskiy.domain.enums.CleanserName;
import by.zabavskiy.domain.enums.ClothesName;
import by.zabavskiy.domain.enums.ShoesName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {
        "calendar"
})
@ToString(exclude = {
        "calendar"
})
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "m_equipment")
public class Equipment implements Serializable {

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
    private CleanserName cleanser = CleanserName.NOT_SELECTED;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blocked", column = @Column(name = "is_blocked")),
    })
    private CurrentStatus currentStatus;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "l_calendar_equipment",
            joinColumns = {@JoinColumn(name = "calendar_id")},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id")}
    )
    @JsonIgnoreProperties("equipment")
    private Set<Calendar> calendar = Collections.emptySet();
}
