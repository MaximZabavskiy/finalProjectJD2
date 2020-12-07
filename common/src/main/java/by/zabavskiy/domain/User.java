package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.GoalName;
import by.zabavskiy.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)


public class User implements Serializable {
    /*Here we will store PK of m_users table*/
    private Long id;

    private String name;

    private String surname;

    private String username;

    @JsonIgnore
    private String password;

    private String email;

    private Gender gender = Gender.NOT_SELECTED;

    private Date birthDate;

    private Float height;

    private Float weight;

    private FitnessLevel fitnessLevel = FitnessLevel.NOT_SELECTED;

    private GoalName goalName = GoalName.NOT_SELECTED;

    private Timestamp created;

    private Timestamp changed;

    private Status status = Status.CREATED;

    private boolean isBlocked;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}