package es.pablogdt.thermomix.repositories;

import es.pablogdt.thermomix.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long> {

    List<Ingredient> findByVegetarianFriendly(boolean isVegetarian);
    List<Ingredient> findByCaloriesPer100GrLessThanEqual(int minCalories);
    List<Ingredient> findByCaloriesPer100GrGreaterThanEqual(int maxCalories);
    Ingredient findByName(String name);

}
