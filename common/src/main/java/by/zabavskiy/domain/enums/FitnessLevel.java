package by.zabavskiy.domain.enums;

public enum FitnessLevel {
    NEWBIE ("I've never tried before"),
    BEGINNER ("Some experience"),
    INTERMEDIATE ("Moderate experience with consistent training"),
    ADVANCED ("Very experienced with consistent training"),
    NOT_SELECTED;

    FitnessLevel() {
    }

    FitnessLevel(String description) {
    }
}
