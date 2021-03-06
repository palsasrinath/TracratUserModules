package com.mk.tracrat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.tracrat.dao.UserUpdateDao;
import com.mk.tracrat.dto.UserAddressDto;
import com.mk.tracrat.dto.UserDto;
import com.mk.tracrat.dto.UserOrganizationDto;
import com.mk.tracrat.dto.UserPermissionDto;
import com.mk.tracrat.dto.UserRoleDto;
import com.mk.tracrat.dto.UserUpdateDto;

@Service
public class UserUpdateService {
	@Autowired
	private UserUpdateDao dao;

	public String userUpdate(UserDto dto) {
		System.out.println("service1 update dto" + dto);
		int count = dao.userUpdate(dto);
		System.out.println("service2 update dto" + dto);
		if (count == 0)
			return "User Updation is failed";
		else
			return "User Updation is success";
	}

	public String organizationUpdate(UserOrganizationDto dto) {
		System.out.println("service1 update dto" + dto);
		int count = dao.organizationUpdate(dto);
		System.out.println("service2 update dto" + dto);
		if (count == 0)
			return "User Updation is failed";
		else
			return "User Updation is success";
	}

	public String userRole(UserRoleDto dto) {
		int count = dao.userRole(dto);
		if (count == 0)
			return "User Role Updation is failed";
		else
			return "User Role Updation is success";
	}

	public String addressUpdate(UserAddressDto dto) {
		System.out.println("service1 update dto" + dto);
		int count = dao.addressUpdate(dto);
		System.out.println("service2 update dto" + dto);
		if (count == 0)
			return "User Updation is failed";
		else
			return "User Updation is success";
	}

	public String updatePermission(UserPermissionDto dto) {
		System.out.println("service1 update dto" + dto);
		int count = dao.updatePermission(dto);
		System.out.println("service2 update dto" + dto);
		if (count == 0)
			return "permission Updation is failed";
		else
			return "permission Updation is success";
	}

}
