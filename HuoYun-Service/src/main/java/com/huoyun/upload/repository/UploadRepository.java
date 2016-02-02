package com.huoyun.upload.repository;

import org.springframework.data.repository.CrudRepository;
import com.huoyun.upload.entity.Upload;

public interface UploadRepository extends CrudRepository<Upload, Long> {

}
