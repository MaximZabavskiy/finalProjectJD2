package by.zabavskiy.controller.request;

import by.zabavskiy.domain.enums.FitnessLevel;
import by.zabavskiy.domain.enums.Gender;
import by.zabavskiy.domain.enums.Goal;
import lombok.Data;

import java.sql.Date;

@Data
public class UserCreateRequest {

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

    private Boolean isBlocked;

}


