package com.huoyun.api;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huoyun.core.locale.LocaleService;
import com.huoyun.exception.BusinessException;
import com.huoyun.upload.ErrorCode;
import com.huoyun.upload.UploadService;

@Controller
@RequestMapping("/api")
public class DownloadApi {

	@Autowired
	private UploadService uploadService;

	@Autowired
	private LocaleService localeService;

	/*
	 * 直接在浏览器打开该文件
	 */
	@RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable Long id,
			HttpServletResponse response) throws BusinessException {
		File file = this.uploadService.get(id);
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(file);
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);

			return new ResponseEntity<byte[]>(IOUtils.toByteArray(stream),
					headers, HttpStatus.OK);
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.Upload_File_Download_Failed,
					localeService);
		}
	}

	/*
	 * 下载该文件
	 */
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	public @ResponseBody FileSystemResource download(@PathVariable Long id,
			HttpServletResponse response) throws BusinessException {
		File file = this.uploadService.get(id);
		String fileName = file.getName();
		response.setHeader("Content-Disposition", "attachment; filename="
				+ fileName);
		return new FileSystemResource(file);
	}
}
