package es.pablogdt.thermomix.model;

public enum AmountType {
    GRAMES("Gramos"), PINCH("Pizca"), SPOON("Cucharada"), TEASPOON("Cucharada pequeña"), MILLILITERS("Mililitros"),
    PACKET("Paquete"), UNITS ("Unidad");

    private String description;

    private AmountType(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
