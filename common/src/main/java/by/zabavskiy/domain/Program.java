package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Set;



@Data
@Entity
@EqualsAndHashCode(exclude = {
        "user", "workouts", "calendar"
})
@Table(name = "m_programs")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Program implements Serializable {

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
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column(name = "is_blocked")
    private boolean blocked;



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @JsonIgnoreProperties("programs")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(mappedBy = "programs", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Workout> workouts = Collections.emptySet();

    @JsonManagedReference
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Calendar> calendar = Collections.emptySet();

}