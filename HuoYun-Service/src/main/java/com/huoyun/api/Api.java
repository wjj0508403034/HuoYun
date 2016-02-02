package com.huoyun.api;

import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.huoyun.core.tools.HuoYunFieldMapper;
import com.huoyun.core.tools.ListMapper;

public abstract class Api {

	@Autowired
	protected Mapper mapper;

	@Autowired
	protected ListMapper listMapper;

	public <T, S> void copy(Map<String, Object> propsHash,
			Class<S> sourceClass, T destination) {

		S source = mapper.map(propsHash, sourceClass);
		DozerBeanMapper newMapper = new DozerBeanMapper();
		newMapper.setCustomFieldMapper(new HuoYunFieldMapper(propsHash));
		newMapper.map(source, destination);
	}
}
