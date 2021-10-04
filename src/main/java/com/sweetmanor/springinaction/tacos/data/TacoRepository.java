package com.sweetmanor.springinaction.tacos.data;

import com.sweetmanor.springinaction.tacos.domain.Taco;

public interface TacoRepository {

	Taco save(Taco design);

}
