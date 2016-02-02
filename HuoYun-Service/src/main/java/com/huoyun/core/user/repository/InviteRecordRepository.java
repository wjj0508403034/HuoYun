package com.huoyun.core.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.core.user.entity.InviteRecord;

public interface InviteRecordRepository extends CrudRepository<InviteRecord, Long>{

	public InviteRecord findByEmail(String email);
}
