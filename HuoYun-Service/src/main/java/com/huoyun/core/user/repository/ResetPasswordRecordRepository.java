package com.huoyun.core.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.user.entity.ResetPasswordRecord;

public interface ResetPasswordRecordRepository extends CrudRepository<ResetPasswordRecord, Long>{

	public ResetPasswordRecord findByCode(String code);
}
