package es.pablogdt.thermomix.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String name;

    private int caloriesPer100Gr;

    private boolean vegetarianFriendly;

}
