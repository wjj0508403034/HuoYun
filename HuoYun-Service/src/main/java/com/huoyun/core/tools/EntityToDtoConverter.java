package com.huoyun.core.tools;

import org.dozer.Mapper;
import org.springframework.core.convert.converter.Converter;

public class EntityToDtoConverter<S, T> implements Converter<S, T> {

	private Mapper mapper;

	private final Class<T> targetType;

	public EntityToDtoConverter(Mapper mapper, Class<T> targetType) {
		this.mapper = mapper;
		this.targetType = targetType;
	}

	@Override
	public T convert(S source) {
		return mapper.map(source, this.targetType);
	}
}
