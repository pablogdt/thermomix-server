package es.pablogdt.thermomix.controllers;

import es.pablogdt.thermomix.model.Ingredient;
import es.pablogdt.thermomix.services.IngredientCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "ingredient")
public class IngredientCrudController {

    @Autowired
    private IngredientCrudService ingredientCrudService;

    @PostMapping("/add")
    @ResponseBody
    public Ingredient addIngredient(@RequestBody final Ingredient ingredient) {
        return ingredientCrudService.addIngredient(ingredient);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Ingredient> findAllIngredients(final Pageable pageable) {
        return ingredientCrudService.findAllIngredients(pageable);
    }

    @GetMapping("/vegetarian")
    @ResponseBody
    public List<Ingredient> findVegetarianIngredients() {
        return ingredientCrudService.findVegetarianIngredients();
    }

    @GetMapping("/lowCalories/{maxCalories}")
    @ResponseBody
    public List<Ingredient> findIngredientsLowerThanCalories(@PathVariable("maxCalories") final int maxCalories) {
        return ingredientCrudService.findIngredientsLowerThanEqualCalories(maxCalories);
    }

    @GetMapping("/highCalories/{minCalories}")
    @ResponseBody
    public List<Ingredient> findIngredientsUpperThanCalories(@PathVariable("minCalories") final int minCalories) {
        return ingredientCrudService.findIngredientsUpperThanEqualCalories(minCalories);
    }

}
