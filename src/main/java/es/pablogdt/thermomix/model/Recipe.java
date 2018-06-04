package es.pablogdt.thermomix.model;

import lombok.Data;

import javax.persistence.*;
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

//    @ManyToMany
//    private Set<RecipeIngredient> recipeIngredients;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//(mappedBy = "recipe")
    private List<Step> steps;
}
