package by.zabavskiy.domain.hibernate;

import by.zabavskiy.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {
        "user", "program", "workout", "equipment"
})
@ToString(exclude = {
        "user", "program", "workout", "equipment"
})
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "m_calendar")
public class HibernateCalendar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private Status status = Status.CREATED;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private HibernateUser user;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    @JsonBackReference
    private HibernateProgram program;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    @JsonBackReference
    private HibernateWorkout workout;


    @JsonIgnoreProperties("calendar")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(mappedBy = "calendar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HibernateEquipment> equipment = Collections.emptySet();
}


