package by.zabavskiy.controller.request;

import by.zabavskiy.domain.enums.ProgramDifficulty;
import by.zabavskiy.domain.enums.ProgramDuration;
import by.zabavskiy.domain.enums.ProgramName;
import by.zabavskiy.domain.enums.ProgramType;
import lombok.Data;

@Data
public class ProgramCreateRequest {

    private Long userId;

    private ProgramName name = ProgramName.NOT_SELECTED;

    private ProgramDifficulty difficulty = ProgramDifficulty.NOT_SELECTED;

    private ProgramDuration duration = ProgramDuration.NOT_SELECTED;

    private ProgramType type = ProgramType.NOT_SELECTED;

}
