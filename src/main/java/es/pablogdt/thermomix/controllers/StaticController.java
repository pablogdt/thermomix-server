package es.pablogdt.thermomix.controllers;

import es.pablogdt.thermomix.model.ActionType;
import es.pablogdt.thermomix.model.AmountType;
import es.pablogdt.thermomix.model.RecipeCategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "static")
public class StaticController {

    @GetMapping("/amounts")
    @ResponseBody
    public Map<String, String> getAmounts() {
        Map<String, String> map = new HashMap<>();
        for (AmountType amountType : AmountType.values()) {
            map.put(amountType.name(), amountType.getDescription());
        }
        return map;
    }

    @GetMapping("/categories")
    @ResponseBody
    public Map<String, String> getCategories() {
        Map<String, String> map = new HashMap<>();
        for (RecipeCategory recipeCategory : RecipeCategory.values()) {
            map.put(recipeCategory.name(), recipeCategory.getDescription());
        }
        return map;
    }

    @GetMapping("/actions")
    @ResponseBody
    public Map<String, String> getActions() {
        Map<String, String> map = new HashMap<>();
        for (ActionType actionType : ActionType.values()) {
            map.put(actionType.name(), actionType.getDescription());
        }
        return map;
    }

}
