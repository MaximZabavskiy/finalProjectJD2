package by.zabavskiy.domain.hibernate;

import by.zabavskiy.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {
        "user", "workouts", "calendar"
})
@ToString(exclude = {
        "user", "workouts", "calendar"
})
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "m_programs")

public class HibernateProgram implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ProgramName name = ProgramName.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private ProgramDifficulty difficulty = ProgramDifficulty.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private ProgramDuration duration = ProgramDuration.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private ProgramType type = ProgramType.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private HibernateUser user;

    @JsonIgnoreProperties("programs")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(mappedBy = "programs", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HibernateWorkout> workouts = Collections.emptySet();

    @JsonManagedReference
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HibernateCalendar> calendar = Collections.emptySet();

}