package by.zabavskiy.domain;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Entity
@EqualsAndHashCode(exclude = {
        "user"
})
@Table(name = "m_perfomance")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Perfomance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "max_pullups")
    private Long maxPullups;

    @Column(name = "max_pushups")
    private Long maxPushups;

    @Column(name = "max_squats")
    private Long maxSquats;

    @Column(name = "max_dips")
    private Long maxDips;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blocked", column = @Column(name = "is_blocked")),
    })
    private CurrentStatus currentStatus;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
