package com.mk.tracrat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.tracrat.command.UserAddressVo;
import com.mk.tracrat.dao.UserInsertDao;
import com.mk.tracrat.dto.UserAddressDto;
import com.mk.tracrat.dto.UserDto;
import com.mk.tracrat.dto.UserOrganizationDto;
import com.mk.tracrat.dto.UserPermissionDto;
import com.mk.tracrat.dto.UserRoleDto;

@Service
public class UserInsertService {
	@Autowired
	private UserInsertDao dao;

	// Inserting user details in database
	public String userInsert(UserDto dto) {
		int count = dao.userInsert(dto);
		System.out.println("service dto" + dto);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";
	}

	// Inserting user address into database
	public String userAddress(UserAddressDto dto) {
		int count = dao.userAddress(dto);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";
	}

	public String userRole(UserRoleDto dto) {
		int count = dao.userRole(dto);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";
	}

	public String userPermission(UserPermissionDto dto) {
		int count = dao.userPermission(dto);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";
	}

	public String userOrganization(UserOrganizationDto dto) {
		int count = dao.userOrganization(dto);
		if (count == 0)
			return "insert failed";
		else
			return "insertion is success";
	}

	public List<UserDto> getUserDetails(UserDto dto) {
		return dao.getUserDetails(dto);
		
	}

	public List<UserAddressDto> getAddressDetails(UserAddressDto dto) {
		return dao.getAddressDetails(dto);
	}

	public List<UserPermissionDto> getPermissionDetails(UserPermissionDto dto) {
		return dao.getPermissionDetails(dto);
	}

	public List<UserOrganizationDto> getOrganizationDetails(UserOrganizationDto dto) {
		return dao.getOrganizationDetails(dto);
	}
	public List<UserRoleDto> getRoleDetails(UserRoleDto dto){
		List<UserRoleDto> udto=dao.getRoleDetails(dto);
		System.out.println("service  "+udto);
		return udto;
		
	}
	public List<UserDto> getUser(int user_id) {
		List<UserDto> res =dao.getUser(user_id);
		System.out.println("service   list  "+res);		
		return res;
			}


}
