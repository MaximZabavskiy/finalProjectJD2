package by.zabavskiy.controller.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

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
    private String username;

    private String surname;

    private Date birthDate;

    private String login;

    private String password;

    private Float weight;
}


