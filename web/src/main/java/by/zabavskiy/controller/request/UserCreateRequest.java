package by.zabavskiy.controller.request;

import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.GoalName;
import by.zabavskiy.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "User creation model")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserCreateRequest {

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 200)
    @ApiModelProperty(required = true, dataType = "string", notes = "user first name")

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

    private Status status = Status.CREATED;


}


