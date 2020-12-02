package by.zabavskiy.domain;


import by.zabavskiy.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Calendar implements Serializable {

    private Long id;

    private Long userId;

    private Long programId;

    private Long workoutId;

    private Long equipmentId;

    private Date date;

    private Status status = Status.CREATED;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
