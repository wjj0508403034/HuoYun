package com.huoyun.upload;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.huoyun.exception.BusinessException;

public interface UploadService {

	long upload(MultipartFile file) throws BusinessException;
	
	File get(Long id) throws BusinessException;
}
