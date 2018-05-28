package es.pablogdt.thermomix.services;

import com.google.common.collect.Lists;
import es.pablogdt.thermomix.model.Ingredient;
import es.pablogdt.thermomix.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientCrudService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient addIngredient(final Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findVegetarianIngredients() {
        return ingredientRepository.findByVegetarianFriendly(true);
    }

    public List<Ingredient> findIngredientsLowerThanEqualCalories(int maxCalories) {
        return ingredientRepository.findByCaloriesPer100GrLessThanEqual(maxCalories);
    }

    public List<Ingredient> findIngredientsUpperThanEqualCalories(int minCalories) {
        return ingredientRepository.findByCaloriesPer100GrGreaterThanEqual(minCalories);
    }

    public List<Ingredient> findAllIngredients(final Pageable pageable) {
        return Lists.newArrayList(ingredientRepository.findAll(pageable));
    }
}
