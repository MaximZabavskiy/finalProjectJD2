package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.SystemRoles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {
        "user"
})
@Table(name = "m_roles")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
@Builder
public class Role implements Serializable {

    public Role() {
    }

    public Role(Long id, SystemRoles roleName, Boolean blocked) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role(SystemRoles roleName, User user) {
        this.roleName = roleName;
        this.user = user;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private SystemRoles roleName = SystemRoles.ROLE_USER;

    @Column
    private Timestamp created;

    @Column
    private Timestamp changed;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blocked", column = @Column(name = "is_blocked")),
    })
    private CurrentStatus currentStatus;



    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
