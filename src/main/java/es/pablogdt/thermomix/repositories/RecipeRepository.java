package es.pablogdt.thermomix.repositories;

import es.pablogdt.thermomix.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {

    List<Recipe> findByCategory(String category);

    @Query("SELECT r FROM Recipe r JOIN Step s JOIN RecipeIngredient ri JOIN FETCH Ingredient i WHERE i.name LIKE '%?1%'")
    List<Recipe> findByIngredient(String ingredient);
}
