package by.zabavskiy.domain.hibernate;

import by.zabavskiy.domain.enums.Status;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {
        "user"
})
@ToString(exclude = {
        "user"
})
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "m_perfomance")

public class HibernatePerfomance implements Serializable {

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
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private HibernateUser user;
}
