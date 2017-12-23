package com.mk.tracrat.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mk.tracrat.command.UserAddressVo;
import com.mk.tracrat.dto.UserAddressDto;
import com.mk.tracrat.dto.UserDto;
import com.mk.tracrat.dto.UserOrganizationDto;
import com.mk.tracrat.dto.UserPermissionDto;
import com.mk.tracrat.dto.UserRoleDto;

@Repository
public class UserInsertDaoImpl implements UserInsertDao {
	@Autowired
	private JdbcTemplate jt;
	private static final String INSERT_USER_DATA = "call procedure_insert_user(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ADDRESS = "call procedure_insert_address(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ROLE = "call procedure_insert_role(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_PERMISSION = "call procedure_insert_permission(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ORGANIZATION = "call procedure_insert_Organization(?,?,?,?,?,?)";

	private static final String GET_ORG_USER = "SELECT * FROM T_USER_CREATE";
	private static final String GET_USER_ORGANIZATION = "SELECT * FROM T_ORGANIZATION_CREATE";
	private static final String GET_USER_ROLE = "SELECT * FROM T_ROLE_CREATE";
	private static final String GET_USER_PERMISSION = "SELECT * FROM T_PERMISSION_CREATE";
	private static final String GET_USER_ADDRESS = "SELECT * FROM T_ADDRESS_CREATE";
	private static final String GET_USER_BYID="SELECT * FROM T_USER_CREATE WHERE USER_ID=?";
	@Override
	public int userInsert(UserDto dto) {
		int result = jt.update(INSERT_USER_DATA, dto.getUser_id(), dto.getOrg_id(), dto.getFirst_name(),
				dto.getLast_name(), dto.getAge(), dto.getGender(), dto.getMobile_number(), dto.getSuperUserFlag(),
				dto.getStatus(), dto.getCreated_date(), dto.getCreated_by(), dto.getModified_date(),
				dto.getModified_by());

		return result;
	}

	@Override
	public int userAddress(UserAddressDto dto) {
		int responce = jt.update(INSERT_USER_ADDRESS, dto.getAddress_id(), dto.getUser_id(), dto.getAddress1(),
				dto.getAddress2(), dto.getState(), dto.getCountry(), dto.getPin());
		return responce;
	}

	@Override
	public int userRole(UserRoleDto dto) {
		int responce = jt.update(INSERT_USER_ROLE, dto.getRole_id(), dto.getUser_id(), dto.getStatus(),
				dto.getCreated_date(), dto.getCreated_by(), dto.getModified_date(), dto.getModified_by());
		return responce;
	}

	@Override
	public int userPermission(UserPermissionDto dto) {
		int responce = jt.update(INSERT_USER_PERMISSION, dto.getPermission_id(), dto.getRole_id(), dto.getStatus(),
				dto.getCreated_date(), dto.getCreated_by(), dto.getModified_date(), dto.getModified_by());
		return responce;
	}

	@Override
	public int userOrganization(UserOrganizationDto dto) {
		int responce = jt.update(INSERT_USER_ORGANIZATION, dto.getOrg_id(), dto.getStatus(), dto.getCreated_date(),
				dto.getCreated_by(), dto.getModified_date(), dto.getModified_by());
		return responce;
	}

	@Override
	public List<UserDto> getUserDetails(UserDto dto) {
		List<UserDto> userList = jt.query(GET_ORG_USER, new BeanPropertyRowMapper(UserDto.class));
		return userList;
	}

	@Override
	public List<UserAddressDto> getAddressDetails(UserAddressDto dto) {
		List<UserAddressDto> addressList = jt.query(GET_USER_ADDRESS, new BeanPropertyRowMapper(UserAddressDto.class));
		return addressList;
	}

	@Override
	public List<UserPermissionDto> getPermissionDetails(UserPermissionDto dto) {
		List<UserPermissionDto> permissionList = jt.query(GET_USER_PERMISSION,
				new BeanPropertyRowMapper(UserPermissionDto.class));
		return permissionList;
	}

	@Override
	public List<UserOrganizationDto> getOrganizationDetails(UserOrganizationDto dto) {
		List<UserOrganizationDto> organizationList = jt.query(GET_USER_ORGANIZATION,
				new BeanPropertyRowMapper(UserOrganizationDto.class));
		return organizationList;
	}

	@Override
	public List<UserRoleDto> getRoleDetails(UserRoleDto dto) {
		List<UserRoleDto> listDto = jt.query(GET_USER_ROLE, new BeanPropertyRowMapper(UserRoleDto.class));
		System.out.println("dao   " + listDto);
		return listDto;
	}
	
	@Override
	public List<UserDto> getUser(int user_id) {
		System.out.println("dao  "+user_id);
List<UserDto> dto=jt.query(GET_USER_BYID, new BeanPropertyRowMapper(UserDto.class), user_id);
System.out.println("res dao  "+dto);		
return dto;
	}

}
