package es.pablogdt.thermomix.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Step {
    @Id
    @GeneratedValue
    private Long id;
    private int stepOrder;
    private ActionType action;
    private Integer time;
    private TimeUnit timeUnit;
    private Integer speed;
    private Integer temperature;
    private String description;
    private boolean usesThermomix = true;

    @OneToMany(mappedBy="step", cascade=CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredientsToAdd;

//    @ManyToOne
//    private Recipe recipe;


    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", stepOrder=" + stepOrder +
                ", action=" + action +
                ", time=" + time +
                ", timeUnit=" + timeUnit +
                ", speed=" + speed +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                ", usesThermomix=" + usesThermomix +
                ", recipeIngredientsToAdd=" +
                (recipeIngredientsToAdd == null ? null : recipeIngredientsToAdd.stream().map(recipeIngredient -> recipeIngredient.getIngredient().getName()).collect(Collectors.toList())) +
                '}';
    }
}
