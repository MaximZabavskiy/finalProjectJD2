package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)


public class Program implements Serializable {
    private Long id;

    private String userId;

    private ProgramName name = ProgramName.NOT_SELECTED;

    private ProgramDifficulty difficulty = ProgramDifficulty.NOT_SELECTED;

    private ProgramDuration duration = ProgramDuration.NOT_SELECTED;

    private ProgramType type = ProgramType.NOT_SELECTED;

    private Status status = Status.CREATED;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
