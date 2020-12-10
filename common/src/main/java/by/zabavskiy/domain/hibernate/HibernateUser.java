package by.zabavskiy.domain.hibernate;

import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.GoalName;
import by.zabavskiy.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {
        "roles", "programs", "workouts", "calendar","perfomance"
})
@ToString(exclude = {
        "roles", "programs", "workouts", "calendar","perfomance"
})
@Entity
@Table(name = "m_users")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.hibernate.annotations.NamedQuery(name = "HibernateUser_findAll",
        query = "select user from HibernateUser user order by user.id desc")

public class HibernateUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String username;

    @Column
    private String password;

    //What is it?!!!

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "created", column = @Column(name = "created")),
            @AttributeOverride(name = "changed", column = @Column(name = "changed"))
    })
    private TimedEntity profileUpdates;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.NOT_SELECTED;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column
    private Float height;

    @Column
    private Float weight;

    @Column
    @Enumerated(EnumType.STRING)
    private FitnessLevel fitnessLevel = FitnessLevel.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private GoalName goalName = GoalName.NOT_SELECTED;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @Column(name = "is_blocked")
    private boolean blocked;

    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<HibernateRole> roles = Collections.emptySet();

    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HibernateProgram> programs = Collections.emptySet();

    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HibernateWorkout> workouts = Collections.emptySet();

    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HibernateCalendar> calendar = Collections.emptySet();

    @OneToOne(mappedBy = "user")
    private HibernatePerfomance perfomance;

}
