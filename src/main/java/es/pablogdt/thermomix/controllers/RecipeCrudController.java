package es.pablogdt.thermomix.controllers;

import es.pablogdt.thermomix.model.Recipe;
import es.pablogdt.thermomix.services.RecipeCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "recipe")
public class RecipeCrudController {

    @Autowired
    private RecipeCrudService recipeCrudService;

    @PostMapping("/add")
    @ResponseBody
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeCrudService.addRecipe(recipe);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public Recipe modifyRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) throws Exception {
        return recipeCrudService.modifyRecipe(id, recipe);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Recipe findById(@PathVariable("id") Long id) {
        return recipeCrudService.findById(id);
    }

    @GetMapping("/find/category/{category}")
    @ResponseBody
    public List<Recipe> findByCategory(@PathVariable("category") String category) {
        return recipeCrudService.findRecipesByCategory(category);
    }

    @GetMapping("/find/ingredient/{ingredient}")
    @ResponseBody
    public List<Recipe> findByIngredient(@PathVariable("ingredient") String ingredient) {
        return recipeCrudService.findRecipesByIngredient(ingredient);
    }

    @GetMapping("/find/ingredient/id/{id}")
    @ResponseBody
    public List<Recipe> findByIngredientId(@PathVariable("id") Long id) {
        return recipeCrudService.findRecipesByIngredientId(id);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Recipe> findAll(final Pageable pageable) {
        return recipeCrudService.findAllRecipes(pageable);
    }

    @PostMapping("/remove/{id}")
    @ResponseBody
    public boolean removeById(@PathVariable("id") final Long id) {
        return recipeCrudService.removeById(id);
    }
}
