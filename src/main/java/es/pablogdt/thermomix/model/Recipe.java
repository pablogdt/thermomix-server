package es.pablogdt.thermomix.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private RecipeCategory category;

    @Enumerated(EnumType.STRING)
    private ThermomixModel thermomixModel;

    private Integer servings;

    @Transient
    private Integer calories = 0;

    @Transient
    private List<String> warnings = new ArrayList<>();

    @Transient
    private boolean isVegetarian = true;

//    @ManyToMany
//    private Set<RecipeIngredient> recipeIngredients;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//(mappedBy = "recipe")
    private List<Step> steps;

    @PostLoad
    public void calculateAge() {
        for (Step step : steps) {
            for (RecipeIngredient recipeIngredient : step.getRecipeIngredientsToAdd()) {
                //Vegetarian calculation
                if (!recipeIngredient.getIngredient().isVegetarianFriendly()) {
                    isVegetarian = false;
                }
                //Calories calculation
                if (recipeIngredient.getAmountType().equals(AmountType.GRAMES)) {
                    calories += Math.round(recipeIngredient.getAmount() / 100.0f * recipeIngredient.getIngredient().getCaloriesPer100Gr());
                } else {
                    if (recipeIngredient.getIngredient().getCaloriesPer100Gr() > 0) {
                        warnings.add(recipeIngredient.getIngredient().getName() + " calories not added because it has as amount type " + recipeIngredient.getAmountType() + " (not GRAMES)");
                    }
                }
            }
        }
    }
}
