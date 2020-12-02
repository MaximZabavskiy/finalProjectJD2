package by.zabavskiy.domain;

import by.zabavskiy.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.security.Timestamp;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)


public class Equipment implements Serializable {

    private Long id;

    private ClothesName clothes = ClothesName.NOT_SELECTED;

    private ShoesName shoes = ShoesName.NOT_SELECTED;

    private BeverageName beverage = BeverageName.NOT_SELECTED;

    private CleansersName cleansers = CleansersName.NOT_SELECTED;

    private Status status = Status.CREATED;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}