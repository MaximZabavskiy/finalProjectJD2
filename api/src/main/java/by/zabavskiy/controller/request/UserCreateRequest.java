package by.zabavskiy.controller.request;

import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.Goal;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
public class UserCreateRequest {

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 200)
    @ApiModelProperty(required = true, dataType = "string", notes = "user first name")
    private String name;

    private String surname;

    private String login;

    private String password;

    private String email;

    private Gender gender = Gender.NOT_SELECTED;

    private Date birthDate;

    private Float height;

    private Float weight;

    private FitnessLevel fitnessLevel = FitnessLevel.NOT_SELECTED;

    private Goal goal = Goal.NOT_SELECTED;

    private Long maxPullups;

    private Long maxPushups;

    private Long maxSquats;

    private Long maxDips;

}


