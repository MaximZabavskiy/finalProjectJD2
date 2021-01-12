package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.ProgramDifficulty;
import by.zabavskiy.domain.enums.ProgramDuration;
import by.zabavskiy.domain.enums.ProgramName;
import by.zabavskiy.domain.enums.ProgramType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
        "user", "workouts", "calendar"
})
@Table(name = "m_programs")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
@AllArgsConstructor
public class Program implements Serializable {

    public Program() {

    }

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blocked", column = @Column(name = "is_blocked")),
    })
    private CurrentStatus currentStatus;


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