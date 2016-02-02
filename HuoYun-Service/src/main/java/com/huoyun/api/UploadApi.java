package com.huoyun.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huoyun.exception.BusinessException;
import com.huoyun.upload.UploadService;

@Controller
@RequestMapping("/api")
public class UploadApi {

	@Autowired
	private UploadService uploadService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody long upload(@RequestParam("file") MultipartFile file) throws BusinessException {
		return this.uploadService.upload(file);
	}
}
