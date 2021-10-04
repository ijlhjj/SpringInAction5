package com.sweetmanor.springinaction.tacos.data.impl;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.sweetmanor.springinaction.tacos.domain.Ingredient;
import com.sweetmanor.springinaction.tacos.domain.Taco;

/**
 * 改为JPA实现，本类不进行实例化
 */
// @Repository
public class JdbcTacoRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	// @Override
	public Taco save(Taco taco) {
		long tacoId = saveTacoInfo(taco);
		taco.setId(tacoId);
		for (Ingredient ingredient : taco.getIngredients()) {
			saveIngredientToTaco(ingredient, tacoId);
		}
		return taco;
	}

	private long saveTacoInfo(Taco taco) {
		String sql = "insert into Taco (name, createdAt) values (?, ?)";
		taco.setCreatedAt(new Date());
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory(sql, Types.VARCHAR, Types.TIMESTAMP)
				.newPreparedStatementCreator(
						Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getTime())));

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);

		// 没有获取到返回的主键
		return keyHolder.getKey().longValue();
	}

	private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
		String sql = "insert into Taco_Ingredients (taco, ingredient) values (?, ?)";
		jdbc.update(sql, tacoId, ingredient.getId());
	}

}
