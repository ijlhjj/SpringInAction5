package com.sweetmanor.springinaction.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.sweetmanor.springinaction.tacos.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
