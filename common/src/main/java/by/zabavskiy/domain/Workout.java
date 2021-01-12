package by.zabavskiy.domain;


import by.zabavskiy.domain.enums.Exercise;
import by.zabavskiy.domain.enums.MuscleGroup;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {
        "user", "programs", "calendar"
})
@Table(name = "m_workouts")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Workout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "muscle_group")
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup = MuscleGroup.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private Exercise exercise = Exercise.NOT_SELECTED;

    @Column
    private Long rounds;

    @Column
    private Long reps;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blocked", column = @Column(name = "is_blocked")),
    })
    private CurrentStatus currentStatus;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @JsonIgnoreProperties("workouts")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "l_programs_workouts",
            joinColumns = {@JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "program_id")}
    )
    private Set<Program> programs = Collections.emptySet();

    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Calendar> calendar = Collections.emptySet();
}
