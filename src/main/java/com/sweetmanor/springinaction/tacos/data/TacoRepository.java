package com.sweetmanor.springinaction.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.sweetmanor.springinaction.tacos.domain.Taco;

/**
 * JPA实现
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {

}
