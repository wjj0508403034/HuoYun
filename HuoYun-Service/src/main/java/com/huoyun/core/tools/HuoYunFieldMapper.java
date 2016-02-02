package com.huoyun.core.tools;

import java.util.Map;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;

public class HuoYunFieldMapper implements CustomFieldMapper {

	private Map<String, Object> map;

	public HuoYunFieldMapper(){
		
	}
	
	public HuoYunFieldMapper(Map<String, Object> map) {
		this.map = map;
	}

	@Override
	public boolean mapField(Object source, Object destination,
			Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping) {
		if (this.map == null) {
			return false;
		}

		if (this.map.containsKey(fieldMapping.getSrcFieldName())) {
			return false;
		}
		
		return true;
	}

}
