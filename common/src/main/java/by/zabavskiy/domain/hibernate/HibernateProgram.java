package by.zabavskiy.domain.hibernate;

import by.zabavskiy.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {
        "user"
})
@ToString(exclude = {
        "user"
})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "m_programs")

public class HibernateProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String userId;
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
}