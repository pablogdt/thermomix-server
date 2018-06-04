package es.pablogdt.thermomix.model;

public enum RecipeCategory {
    SOUP("Sopa"), MEAT("Carne"), FISH("Pescado"), DESSERT("Postre"), DRINK("Bebida"), SAUCE("Salsa"), CREAM("Crema");

    private String description;

    private RecipeCategory(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
