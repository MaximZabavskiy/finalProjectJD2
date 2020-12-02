package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.Exercise;
import by.zabavskiy.domain.enums.MuscleGroup;
import by.zabavskiy.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Perfomance implements Serializable {

    private Long id;

    private Long userId;

    private Long maxPullups;

    private Long maxPushups;

    private Long maxSquats;

    private Long maxDips;

    private Status status = Status.CREATED;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
