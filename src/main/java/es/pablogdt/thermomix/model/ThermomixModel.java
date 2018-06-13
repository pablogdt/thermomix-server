package es.pablogdt.thermomix.model;

public enum ThermomixModel {
    TM21("TM 21"), TM31("TM 31"), TM5("TM 5");

    private String description;

    ThermomixModel(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
