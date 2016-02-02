package com.huoyun.core.address.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.address.entity.City;
import com.huoyun.core.address.entity.District;

public interface DistrictRepository extends CrudRepository<District, Long> {

	public List<District> findDistrictsByCity(City city);
}
