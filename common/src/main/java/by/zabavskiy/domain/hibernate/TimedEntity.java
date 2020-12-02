package by.zabavskiy.domain.hibernate;

import lombok.Data;

import javax.persistence.Embeddable;
import java.sql.Timestamp;

@Embeddable
@Data
public class TimedEntity {

    private Timestamp created;

    private Timestamp changed;
}
