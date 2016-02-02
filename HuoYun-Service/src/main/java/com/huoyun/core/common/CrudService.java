package com.huoyun.core.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.huoyun.exception.BusinessException;

public interface CrudService<T> {

	void create(T object) throws BusinessException;
	
	T get(Long id);

	void update(T object) throws BusinessException;

	void delete(Long id) throws BusinessException;

	Page<T> query(Pageable pageable);

}
