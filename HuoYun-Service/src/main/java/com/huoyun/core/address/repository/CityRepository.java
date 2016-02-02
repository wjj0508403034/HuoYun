package com.huoyun.core.address.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.address.entity.City;
import com.huoyun.core.address.entity.State;

public interface CityRepository extends CrudRepository<City, Long>{

	public List<City> findCitiesByState(State state);
}
