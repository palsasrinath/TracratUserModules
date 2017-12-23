package com.mk.tracrat.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mk.tracrat.dto.UserDto;

public class UserSelectDaoImpl implements UserSelectDao{
@Autowired
private JdbcTemplate template;
private static final String GET_USER_BYID="SELECT * FROM T_USER_CREATE WHERE USER_ID=?";
	@Override
	public List<UserDto> getUser(int user_id) {
		System.out.println("dao  "+user_id);
List<UserDto> dto=template.query(GET_USER_BYID, new BeanPropertyRowMapper(UserDto.class), user_id);
System.out.println("res dao  "+dto);		
return dto;
	}

}
