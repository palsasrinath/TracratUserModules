package com.mk.tracrat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mk.tracrat.dto.UserAddressDto;
import com.mk.tracrat.dto.UserDto;
import com.mk.tracrat.dto.UserOrganizationDto;
import com.mk.tracrat.dto.UserPermissionDto;
import com.mk.tracrat.dto.UserRoleDto;

@Repository
public class UserInsertDaoImpl implements UserInsertDao {
	@Autowired
	private JdbcTemplate jt;
	private static final String INSERT_USER_DATA = "call p_User_table(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ADDRESS = "call p_Address_table(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ROLE = "call p_Role_table(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_PERMISSION = "call p_parmission_table(?,?,?,?,?,?,?)";
	private static final String INSERT_USER_ORGANIZATION = "call p_insert_Organization(?,?,?,?,?,?)";

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
}
