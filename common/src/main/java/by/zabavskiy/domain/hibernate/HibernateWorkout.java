package by.zabavskiy.domain.hibernate;


import by.zabavskiy.domain.enums.Exercise;
import by.zabavskiy.domain.enums.MuscleGroup;
import by.zabavskiy.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cache;
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
        "user", "programs", "calendar"
})
@ToString(exclude = {
        "user", "programs", "calendar"
})
@Entity
@Table(name = "m_workouts")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class HibernateWorkout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup = MuscleGroup.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private Exercise exercises = Exercise.NOT_SELECTED;

    @Column
    private Long rounds;

    @Column
    private Long reps;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private HibernateUser user;

    @JsonIgnoreProperties("workouts")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "l_programs_workouts",
            joinColumns = {@JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "program_id")}
    )
    private Set<HibernateProgram> programs = Collections.emptySet();

    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HibernateCalendar> calendar = Collections.emptySet();

}
