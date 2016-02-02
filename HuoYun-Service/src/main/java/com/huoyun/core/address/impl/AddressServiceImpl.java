package com.huoyun.core.address.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.huoyun.core.address.AddressService;
import com.huoyun.core.address.entity.City;
import com.huoyun.core.address.entity.Country;
import com.huoyun.core.address.entity.District;
import com.huoyun.core.address.entity.State;
import com.huoyun.core.address.repository.CityRepository;
import com.huoyun.core.address.repository.CountryRepository;
import com.huoyun.core.address.repository.DistrictRepository;
import com.huoyun.core.address.repository.StateRepository;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.BusinessObjectNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {

	private static Logger logger = Logger.getLogger(AddressServiceImpl.class);

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private LocaleService localeService;

	@Override
	public List<Country> getCountries() {
		return (List<Country>) Lists.newArrayList(this.countryRepository
				.findAll());
	}

	@Override
	public List<State> getStates(long countryId) throws BusinessException {
		Country country = this.countryRepository.findOne(countryId);
		if (country == null) {
			logger.error("Cannot find country");
			throw new BusinessObjectNotFoundException(Country.class,countryId,
					localeService);
		}

		return this.stateRepository.findStatesByCountry(country);
	}

	@Override
	public List<City> getCities(long stateId) throws BusinessException {
		State state = this.stateRepository.findOne(stateId);
		if (state == null) {
			logger.error("Cannot find state");
			throw new BusinessObjectNotFoundException(State.class,stateId,
					localeService);
		}

		return this.cityRepository.findCitiesByState(state);
	}

	@Override
	public List<District> getDistrict(long cityId) throws BusinessException {
		City city = this.cityRepository.findOne(cityId);
		if (city == null) {
			logger.error("Cannot find city");
			throw new BusinessObjectNotFoundException(City.class,cityId,
					localeService);
		}

		return this.districtRepository.findDistrictsByCity(city);
	}

}
