package es.pablogdt.thermomix.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Ingredient ingredient;

    private int amount;

    private AmountType amountType = AmountType.GRAMES;

    @ManyToOne(cascade=CascadeType.ALL)
    @JsonManagedReference
    private Step step;

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", amountType=" + amountType +
                ", stepId=" + step.getId() +
                '}';
    }
}
