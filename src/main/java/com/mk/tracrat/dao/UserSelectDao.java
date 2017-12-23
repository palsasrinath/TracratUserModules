package com.mk.tracrat.dao;

import java.util.List;

import com.mk.tracrat.dto.UserDto;

public interface UserSelectDao {

	List<UserDto> getUser(int user_id);

}
