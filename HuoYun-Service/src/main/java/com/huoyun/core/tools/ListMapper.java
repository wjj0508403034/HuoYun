package com.huoyun.core.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.dozer.MappingException;

public class ListMapper {

	private Mapper mapper;

	public ListMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	@SuppressWarnings("rawtypes")
	public <T> List<T> map(Collection source, Class<T> destinationClass)
			throws MappingException {
		List<T> results = new ArrayList<T>();
		for (Object it : source) {
			results.add(mapper.map(it, destinationClass));
		}
		return results;
	}
}
