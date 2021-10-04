package com.sweetmanor.springinaction.tacos.data;

import java.util.List;

import com.sweetmanor.springinaction.tacos.domain.Ingredient;

public interface IngredientRepository {

	List<Ingredient> findAll();

	Ingredient findById(String id);

	Ingredient save(Ingredient ingredient);

}
