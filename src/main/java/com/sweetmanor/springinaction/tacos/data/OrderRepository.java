package com.sweetmanor.springinaction.tacos.data;

import com.sweetmanor.springinaction.tacos.domain.Order;

public interface OrderRepository {

	Order save(Order order);

}
