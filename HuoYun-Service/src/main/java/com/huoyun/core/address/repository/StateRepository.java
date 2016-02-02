package com.huoyun.core.address.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.address.entity.Country;
import com.huoyun.core.address.entity.State;

public interface StateRepository extends CrudRepository<State, Long>{

	public List<State> findStatesByCountry(Country country);
}
