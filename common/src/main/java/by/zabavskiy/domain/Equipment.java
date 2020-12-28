package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
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



    @JsonIgnoreProperties("programs")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "l_calendar_equipment",
            joinColumns = {@JoinColumn(name = "calendar_id")},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id")}
    )
    private Set<Calendar> calendar = Collections.emptySet();
}
