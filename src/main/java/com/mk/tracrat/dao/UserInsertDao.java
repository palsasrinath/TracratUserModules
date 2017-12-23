package com.mk.tracrat.dao;

import java.util.List;

import com.mk.tracrat.dto.UserAddressDto;
import com.mk.tracrat.dto.UserDto;
import com.mk.tracrat.dto.UserOrganizationDto;
import com.mk.tracrat.dto.UserPermissionDto;
import com.mk.tracrat.dto.UserRoleDto;

public interface UserInsertDao {

	public int userInsert(UserDto dto);

	public int userAddress(UserAddressDto dto);

	public int userRole(UserRoleDto dto);

	public int userPermission(UserPermissionDto dto);

	public int userOrganization(UserOrganizationDto dto);

	public List<UserDto> getUserDetails(UserDto dto);

	public List<UserAddressDto> getAddressDetails(UserAddressDto dto);

	public List<UserPermissionDto> getPermissionDetails(UserPermissionDto dto);

	public List<UserOrganizationDto> getOrganizationDetails(UserOrganizationDto dto);
	public List<UserRoleDto> getRoleDetails(UserRoleDto dto);
	public List<UserDto> getUser(int user_id);

}
