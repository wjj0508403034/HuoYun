package com.huoyun.core.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huoyun.core.extension.endpoint.BoEventListener;
import com.huoyun.core.locale.LocaleService;

public abstract class BoService {

	@Autowired
	protected LocaleService localeService;

	@Autowired
	protected BoFacade boFacade;

	@SuppressWarnings("rawtypes")
	private List<BoEventListener> endPoints = new ArrayList<BoEventListener>();

	protected <T> void register(BoEventListener<T> endpoint) {
		this.endPoints.add(endpoint);
	}

	@SuppressWarnings("unchecked")
	protected <T> void postCreate(T entity) {
		for (BoEventListener<T> endpoint : endPoints) {
			if (endpoint != null) {
				endpoint.postCreate(entity);
			}
		}
	}
}
