package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.*;
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

public class Workout implements Serializable {

    private Long id;

    private Long programId;

    private Long userId;

    private MuscleGroup muscleGroup = MuscleGroup.NOT_SELECTED;

    private Exercise exercises = Exercise.NOT_SELECTED;

    private Long rounds;

    private Long reps;

    private Status status = Status.CREATED;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
