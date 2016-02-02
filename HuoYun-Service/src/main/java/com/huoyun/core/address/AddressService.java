package com.huoyun.core.address;

import java.util.List;

import com.huoyun.core.address.entity.City;
import com.huoyun.core.address.entity.Country;
import com.huoyun.core.address.entity.District;
import com.huoyun.core.address.entity.State;
import com.huoyun.exception.BusinessException;

public interface AddressService {

	List<Country> getCountries();

	List<State> getStates(long countryId) throws BusinessException;

	List<City> getCities(long stateId) throws BusinessException;

	List<District> getDistrict(long cityId) throws BusinessException;
}
