package es.pablogdt.thermomix.model;

public enum ActionType {
    KNEAD("Amasar"), INVERSE_SPIN("Giro inverso"), TURBO("Turbo"), VAROMA_TRAY("Bandeja varoma");

    private String description;

    private ActionType(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
