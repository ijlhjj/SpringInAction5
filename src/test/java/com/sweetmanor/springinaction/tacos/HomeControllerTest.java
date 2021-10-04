package com.sweetmanor.springinaction.tacos;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sweetmanor.springinaction.tacos.data.IngredientRepository;
import com.sweetmanor.springinaction.tacos.data.OrderRepository;
import com.sweetmanor.springinaction.tacos.data.TacoRepository;

@WebMvcTest
class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IngredientRepository ingredientRepository;

	@MockBean
	private TacoRepository designRepository;

	@MockBean
	private OrderRepository orderRepository;

	@Test
	void testHomePage() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"))
				.andExpect(content().string(containsString("Welcome to...")));
	}

}
