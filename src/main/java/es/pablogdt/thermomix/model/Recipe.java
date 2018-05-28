package es.pablogdt.thermomix.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private RecipeCategory category;

//    @ManyToMany
//    private Set<RecipeIngredient> recipeIngredients;

    @OneToMany(cascade = CascadeType.ALL)//(mappedBy = "recipe")
    private List<Step> steps;
}
