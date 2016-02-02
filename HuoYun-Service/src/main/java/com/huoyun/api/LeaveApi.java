package com.huoyun.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huoyun.business.leave.LeaveService;
import com.huoyun.business.leave.dto.LeaveRecordDTO;
import com.huoyun.business.leave.dto.LeaveTypeDTO;
import com.huoyun.business.leave.entity.LeaveRecord;
import com.huoyun.core.tools.EntityToDtoConverter;
import com.huoyun.exception.BusinessException;

@RestController
@RequestMapping("/api/leave")
public class LeaveApi extends Api {

	@Autowired
	private LeaveService leaveService;

	/*
	 * 获取所有请假记录
	 */
	@RequestMapping(path = "/getLeaveRecords", method = RequestMethod.GET)
	public @ResponseBody Page<LeaveRecordDTO> query(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			Sort sort) {
		PageRequest request = new PageRequest(page, size, sort);
		Page<LeaveRecord> pageData = this.leaveService.query(request);
		EntityToDtoConverter<LeaveRecord, LeaveRecordDTO> converter = new EntityToDtoConverter<LeaveRecord, LeaveRecordDTO>(
				mapper, LeaveRecordDTO.class);
		return pageData.map(converter);
	}

	/*
	 * 获取所有请假类型
	 */
	@RequestMapping(path = "/getLeaveTypes", method = RequestMethod.GET)
	public @ResponseBody List<LeaveTypeDTO> getLeaveTypes() {
		return this.listMapper.map(this.leaveService.getLeaveTypes(),
				LeaveTypeDTO.class);
	}

	/*
	 * 创建一个新的请假请求
	 */
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public @ResponseBody void create(@RequestBody LeaveRecordDTO leaveRecordDTO)
			throws BusinessException {
		this.leaveService.create(this.mapper.map(leaveRecordDTO,
				LeaveRecord.class));
	}
}
