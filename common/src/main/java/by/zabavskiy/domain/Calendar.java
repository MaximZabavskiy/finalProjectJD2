package by.zabavskiy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.Set;



@Data
@Entity
@EqualsAndHashCode(exclude = {
        "user", "program", "workout", "equipment"
})
@Table(name = "m_calendar")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Calendar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

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

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    @JsonBackReference
    private Program program;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    @JsonBackReference
    private Workout workout;

    @JsonIgnoreProperties("calendar")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(mappedBy = "calendar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Equipment> equipment = Collections.emptySet();
}


