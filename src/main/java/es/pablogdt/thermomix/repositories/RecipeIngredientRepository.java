package es.pablogdt.thermomix.repositories;

import es.pablogdt.thermomix.model.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long> {

}
