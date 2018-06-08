package es.pablogdt.thermomix.repositories;

import es.pablogdt.thermomix.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {

    List<Recipe> findByCategory(String category);

    @Query("SELECT DISTINCT(r) FROM Recipe r JOIN r.steps step JOIN step.recipeIngredientsToAdd recipeIngredient JOIN recipeIngredient.ingredient ingredient WHERE ingredient.name LIKE CONCAT('%',:ingredient,'%')")
    List<Recipe> findByIngredient(@Param("ingredient") String ingredient);

    @Query("SELECT DISTINCT(r) FROM Recipe r JOIN r.steps step JOIN step.recipeIngredientsToAdd recipeIngredient JOIN recipeIngredient.ingredient ingredient WHERE ingredient.id = :id")
    List<Recipe> findByIngredientId(@Param("id") Long id);
}
