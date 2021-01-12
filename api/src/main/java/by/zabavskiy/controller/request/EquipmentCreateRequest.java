package by.zabavskiy.controller.request;

import by.zabavskiy.domain.enums.BeverageName;
import by.zabavskiy.domain.enums.CleanserName;
import by.zabavskiy.domain.enums.ClothesName;
import by.zabavskiy.domain.enums.ShoesName;
import lombok.Data;

@Data
public class EquipmentCreateRequest {

    private ClothesName clothes = ClothesName.NOT_SELECTED;

    private ShoesName shoes = ShoesName.NOT_SELECTED;

    private BeverageName beverage = BeverageName.NOT_SELECTED;

    private CleanserName cleanser = CleanserName.NOT_SELECTED;

}
