package com.sweetmanor.springinaction.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.sweetmanor.springinaction.tacos.domain.Ingredient;

/**
 * JPA实现
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
