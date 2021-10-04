package com.sweetmanor.springinaction.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.sweetmanor.springinaction.tacos.domain.Order;

/**
 * JPA实现
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}
