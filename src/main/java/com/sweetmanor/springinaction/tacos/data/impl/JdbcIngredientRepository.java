package com.sweetmanor.springinaction.tacos.data.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sweetmanor.springinaction.tacos.data.IngredientRepository;
import com.sweetmanor.springinaction.tacos.domain.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Ingredient> findAll() {
		String sql = "select id, name, type from Ingredient";
		return jdbc.query(sql, this::mapRowToIngredient);
	}

	@Override
	public Ingredient findById(String id) {
		String sql = "select id, name, type from Ingredient where id = ?";
		return jdbc.queryForObject(sql, this::mapRowToIngredient, id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		String sql = "insert into Ingredient (id, name, type) values (?, ?, ?)";
		jdbc.update(sql, ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
		return ingredient;
	}

	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
		return new Ingredient(rs.getString("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));
	}

}
