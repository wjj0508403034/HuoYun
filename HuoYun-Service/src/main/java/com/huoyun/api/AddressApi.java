package com.huoyun.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huoyun.core.address.AddressService;
import com.huoyun.core.address.dto.CityDTO;
import com.huoyun.core.address.dto.CountryDTO;
import com.huoyun.core.address.dto.DistrictDTO;
import com.huoyun.core.address.dto.StateDTO;
import com.huoyun.core.tools.ListMapper;
import com.huoyun.exception.BusinessException;

@Controller
@RequestMapping("/api/address")
public class AddressApi {

	@Autowired
	private AddressService addressService;

	@Autowired
	private ListMapper listMapper;

	@RequestMapping(path = "/countries", method = RequestMethod.GET)
	public @ResponseBody List<CountryDTO> getCountries() {
		return this.listMapper.map(this.addressService.getCountries(),
				CountryDTO.class);
	}

	@RequestMapping(path = "/country({id})/states", method = RequestMethod.GET)
	public @ResponseBody List<StateDTO> getStates(@PathVariable Long id)
			throws BusinessException {
		return this.listMapper.map(this.addressService.getStates(id),
				StateDTO.class);
	}

	@RequestMapping(path = "/state({id})/cities", method = RequestMethod.GET)
	public @ResponseBody List<CityDTO> getCities(@PathVariable Long id)
			throws BusinessException {
		return this.listMapper.map(this.addressService.getCities(id),
				CityDTO.class);
	}

	@RequestMapping(path = "/city({id})/districts", method = RequestMethod.GET)
	public @ResponseBody List<DistrictDTO> getDistricts(@PathVariable Long id)
			throws BusinessException {
		return this.listMapper.map(this.addressService.getDistrict(id),
				DistrictDTO.class);
	}
}
