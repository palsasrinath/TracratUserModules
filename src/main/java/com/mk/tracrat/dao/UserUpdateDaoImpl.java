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
public class UserUpdateDaoImpl implements UserUpdateDao {

	@Autowired
	private JdbcTemplate jt;

	private static final String UPDATE_USER_DATA = "update t_user_create set org_id=?, first_name=?,last_name=?,age=?,gender=?,mobile_number=?,superuserflag=?,status=?,created_date=?,created_by=?,modified_date=?,modified_by=? where user_id=?";
	private static final String UPDATE_USER_ROLE_DATA = "update t_role_create set user_id=?,status=?,created_date=?,created_by=?,modified_date=?,modified_by=? where role_id=?";
	//private static final String UPDATE_ORGANIZATION_DATA = "UPDATE t_organization_create SET status=?,created_date=?,created_by=?,modified_date=?,modified_by=? WHERE org_id=?";
	private static final String UPDATE_ADDRESS_DATA = "UPDATE T_ADDRESS_CREATE SET USER_ID=?,ADDRESS1=?,ADDRESS2=?,STATE=?,COUNTRY=?,PIN=? WHERE ADDRESS_ID=?";
	private static final String UPDATE_PERMISSION_DATA = "update t_permission_create set role_id=?,status=?,created_date=?,created_by=?,modified_date=?,modified_by=? where permission_id=?";
	private static final String UPDATE_ORGANIZATION_DATA = "call p_organization_update(?,?,?,?,?,?)";
	@Override
	public int userUpdate(UserDto dto) {
		System.out.println("dao update controller" + dto);
		int count = jt.update(UPDATE_USER_DATA, dto.getOrg_id(), dto.getFirst_name(), dto.getLast_name(), dto.getAge(),
				dto.getGender(), dto.getMobile_number(), dto.getSuperUserFlag(), dto.getStatus(), dto.getCreated_date(),
				dto.getCreated_by(), dto.getModified_date(), dto.getModified_by(), dto.getUser_id());

		return count;
	}

	@Override
	public int userRole(UserRoleDto dto) {
		int count = jt.update(UPDATE_USER_ROLE_DATA, dto.getUser_id(), dto.getStatus(), dto.getCreated_date(),
				dto.getCreated_by(), dto.getModified_date(), dto.getModified_by(), dto.getRole_id());
		return count;
	}

	@Override
	public int organizationUpdate(UserOrganizationDto dto) {
		System.out.println("dao update controller" + dto);
		int count = jt.update(UPDATE_ORGANIZATION_DATA,dto.getStatus(), dto.getCreated_date(), dto.getCreated_by(),
				dto.getModified_date(), dto.getModified_by(),dto.getOrg_id() );

		return count;
	}

	@Override
	public int addressUpdate(UserAddressDto dto) {
		System.out.println("dao update controller" + dto);
		int count = jt.update(UPDATE_ADDRESS_DATA, dto.getUser_id(), dto.getAddress1(), dto.getAddress2(),
				dto.getState(), dto.getCountry(), dto.getPin(), dto.getAddress_id());

		return count;
	}

	@Override
	public int updatePermission(UserPermissionDto dto) {
		System.out.println("dao update controller" + dto);
		int count = jt.update(UPDATE_PERMISSION_DATA, dto.getRole_id(), dto.getStatus(), dto.getCreated_date(),
				dto.getCreated_by(), dto.getModified_date(), dto.getModified_by(), dto.getPermission_id());

		return count;
	}

}
