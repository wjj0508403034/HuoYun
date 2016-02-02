package com.huoyun.upload.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.huoyun.core.common.BoFacade;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.exception.BusinessException;
import com.huoyun.upload.ErrorCode;
import com.huoyun.upload.UploadProperties;
import com.huoyun.upload.UploadService;
import com.huoyun.upload.entity.Upload;
import com.huoyun.upload.repository.UploadRepository;

@Service
public class UploadServiceImpl implements UploadService {

	private static Logger logger = Logger.getLogger(UploadServiceImpl.class);

	@Autowired
	private LocaleService localeService;

	@Autowired
	private MultipartProperties multipartProperties;

	@Autowired
	private UploadProperties uploadProperties;

	@Autowired
	private UploadRepository uploadRepository;

	@Autowired
	private BoFacade boFacade;

	@Override
	public long upload(MultipartFile file) throws BusinessException {
		this.checkFileExtensionInWhiteList(file.getOriginalFilename());
		this.createUploadDirectory();
		String fileName = this.generateFileName(file.getOriginalFilename());
		String filePath = this.multipartProperties.getLocation() + fileName;
		if (!file.isEmpty()) {
			try {
				this.save(file, filePath);
				Upload upload = this.boFacade.create(Upload.class);
				upload.setOriginalFileName(file.getOriginalFilename());
				upload.setFileName(fileName);
				upload.setSize(file.getSize());
				upload.setRelativePath(fileName);
				this.uploadRepository.save(upload);
				return upload.getId();
			} catch (Exception ex) {
				logger.error("Upload file failed", ex);
				throw new BusinessException(ErrorCode.Upload_File_Failed,
						localeService);
			}
		} else {
			throw new BusinessException(ErrorCode.Upload_File_Failed,
					localeService);
		}
	}

	@Override
	public File get(Long id) throws BusinessException {
		Upload upload = this.uploadRepository.findOne(id);
		if (upload != null) {
			File file = new File(this.multipartProperties.getLocation() + upload.getRelativePath());
			if(file.exists()){
				return file;
			}
		}
		throw new BusinessException(ErrorCode.Upload_File_Download_Failed,
				localeService);
	}

	/*
	 * 保存文件在服务器
	 */
	private void save(MultipartFile file, String filePath) throws Exception {
		byte[] bytes = file.getBytes();

		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(filePath)));
		stream.write(bytes);
		stream.close();
	}

	/*
	 * 生成文件名
	 */
	private String generateFileName(String fileName) {
		return System.currentTimeMillis() + "."
				+ FilenameUtils.getExtension(fileName);
	}

	/*
	 * 创建上传文件所在的文件夹
	 */
	private void createUploadDirectory() throws BusinessException {
		File dir = new File(this.multipartProperties.getLocation());
		if (!dir.exists()) {
			try {
				dir.mkdir();
			} catch (SecurityException ex) {
				logger.error("Create upload file failed", ex);
				throw new BusinessException(
						ErrorCode.Upload_File_Create_Folder_Failed,
						localeService);
			}
		}
	}

	private void checkFileExtensionInWhiteList(String fileName)
			throws BusinessException {
		String ext = FilenameUtils.getExtension(fileName);
		if (!this.uploadProperties.getExtensions().contains(ext)) {
			throw new BusinessException(
					ErrorCode.Upload_File_Extension_Not_Allowed, localeService);
		}
	}

}
