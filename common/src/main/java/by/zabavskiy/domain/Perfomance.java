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

    @Column
    private Long maxPullups;

    @Column
    private Long maxPushups;

    @Column
    private Long maxSquats;

    @Column
    private Long maxDips;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Column(name = "is_blocked")
    private boolean blocked;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
