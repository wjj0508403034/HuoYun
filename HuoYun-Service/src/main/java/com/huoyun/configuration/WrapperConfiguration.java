package com.huoyun.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.huoyun.core.tools.ListMapper;

@Configuration
public class WrapperConfiguration {

	@Bean
	public Mapper mapper() {
		DozerBeanMapper dozerBean = new DozerBeanMapper();
		return dozerBean;
	}
	
	@Bean
	public ListMapper listMapper(){
		return new ListMapper(this.mapper());
	}
}
