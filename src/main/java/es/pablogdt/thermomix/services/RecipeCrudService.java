package es.pablogdt.thermomix.services;

import com.google.common.collect.Lists;
import es.pablogdt.thermomix.model.*;
import es.pablogdt.thermomix.repositories.IngredientRepository;
import es.pablogdt.thermomix.repositories.RecipeIngredientRepository;
import es.pablogdt.thermomix.repositories.RecipeRepository;
import es.pablogdt.thermomix.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RecipeCrudService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private StepRepository stepRepository;

    @Transactional
    public Recipe addRecipe(final Recipe recipe) {
        return saveRecipe(recipe);
    }

    public List<Recipe> findRecipesByCategory(final String category) {
        return recipeRepository.findByCategory(category);
    }

    public List<Recipe> findRecipesByIngredient(final String ingredient) {
        return recipeRepository.findByIngredient(ingredient);
    }

    public List<Recipe> findAllRecipes(final Pageable pageable) {
        return Lists.newArrayList(recipeRepository.findAll(pageable));
    }

    public boolean removeById(final Long id) {
        try {
            recipeRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Recipe findById(final Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe modifyRecipe(final Long id, final Recipe recipe) throws Exception {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (!recipeOptional.isPresent()) {
            throw new Exception("No recipe with id " + id + " was found");
        } else {
            Recipe storedRecipe = recipeOptional.get();
            storedRecipe.getSteps().clear();
            storedRecipe.getSteps().addAll(recipe.getSteps());
            storedRecipe.setCategory(recipe.getCategory());
            storedRecipe.setName(recipe.getName());
            return saveRecipe(storedRecipe);
        }
    }

    private Recipe saveRecipe(Recipe recipe) {
        for (Step step : recipe.getSteps()) {
            if (step.getRecipeIngredientsToAdd() != null && !step.getRecipeIngredientsToAdd().isEmpty()) {
                for (RecipeIngredient recipeIngredientToAdd : step.getRecipeIngredientsToAdd()) {
                    Ingredient persistedIngredient = ingredientRepository.findByName(recipeIngredientToAdd.getIngredient().getName());
                    if (persistedIngredient == null) {
                        ingredientRepository.save(recipeIngredientToAdd.getIngredient());
                    } else {
                        recipeIngredientToAdd.setIngredient(persistedIngredient);
                    }
                    recipeIngredientToAdd.setStep(step);
                }
            }
        }
        return recipeRepository.save(recipe);
    }
}
