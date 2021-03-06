package com.mk.tracrat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mk.tracrat.command.UserAddressVo;
import com.mk.tracrat.command.UserOrganizationVo;
import com.mk.tracrat.command.UserPermissionVo;
import com.mk.tracrat.command.UserRoleVo;
import com.mk.tracrat.command.UserVo;
import com.mk.tracrat.dto.UserAddressDto;
import com.mk.tracrat.dto.UserDto;
import com.mk.tracrat.dto.UserOrganizationDto;
import com.mk.tracrat.dto.UserPermissionDto;
import com.mk.tracrat.dto.UserRoleDto;
import com.mk.tracrat.service.UserInsertService;
import com.mk.tracrat.util.JsonUtil;

@RestController
public class UserInsertController {
	@Autowired
	private UserInsertService service;

	// show user home page
	@GetMapping("/user_home")
	public ModelAndView userInsert() {

		return new ModelAndView("user");
	}

	// show user organization form
	@GetMapping("/user_organization")
	public ModelAndView organization() {
		return new ModelAndView("organization");
	}

	// show user address form
	@GetMapping("/user_address")
	public ModelAndView userAddress() {
		return new ModelAndView("address");
	}

	// show user role form
	@GetMapping("/user_role")
	public ModelAndView userRole() {
		return new ModelAndView("userRole");
	}

	// show user permission form
	@GetMapping("/user_permissions")
	public ModelAndView userPermission() {
		return new ModelAndView("userPermission");
	}

	// show user return to home form
	@GetMapping("/home_return")
	public ModelAndView userReturn() {
		return new ModelAndView("home");
	}
	// show user return to home form
		@GetMapping("/module_details")
		public ModelAndView details() {
			return new ModelAndView("moduleDetails");
		}

	// Inserting user data into data base
	@PostMapping("/user_home")
	// @ResponseBody
	// @Produces(MediaType.))
	public ModelAndView userInsert(@ModelAttribute UserVo cmd) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(cmd, dto);
		String result = service.userInsert(dto);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("address", "result", result);
	}

	// Inserting user address data into database
	@PostMapping("/user_address")
	public ModelAndView userAddress(@ModelAttribute UserAddressVo vo) {
		UserAddressDto dto = new UserAddressDto();
		BeanUtils.copyProperties(vo, dto);
		String responce = service.userAddress(dto);
		String json = JsonUtil.javaToJson(responce);
		return new ModelAndView("userRole", "responce", responce);

	}

	// Inserting user role data into database
	@PostMapping("/user_role")
	public ModelAndView userRole(@ModelAttribute UserRoleVo vo) {
		UserRoleDto dto = new UserRoleDto();
		BeanUtils.copyProperties(vo, dto);
		String responce = service.userRole(dto);
		String json = JsonUtil.javaToJson(responce);
		return new ModelAndView("userPermission", "responce", responce);

	}

	@PostMapping("/user_permission")
	public ModelAndView userPermission(@ModelAttribute UserPermissionVo vo) {
		UserPermissionDto dto = new UserPermissionDto();
		BeanUtils.copyProperties(vo, dto);
		String responce = service.userPermission(dto);
		String json = JsonUtil.javaToJson(responce);
		return new ModelAndView("welcome", "responce", responce);

	}

	@PostMapping("/user_organization")
	public ModelAndView userOrganization(@ModelAttribute UserOrganizationVo vo) {
		UserOrganizationDto dto = new UserOrganizationDto();
		BeanUtils.copyProperties(vo, dto);
		String responce = service.userOrganization(dto);
		String json = JsonUtil.javaToJson(responce);
		return new ModelAndView("welcome", "responce", responce);

	}

	@GetMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getUsers() {
		String user = "Senthil";
		return new ResponseEntity<String>(user, HttpStatus.OK);
	}
	@GetMapping(value = "/get_user_details")
	public ModelAndView getUserDetails(@ModelAttribute UserVo cmd,HttpServletRequest request) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserDto> userList = service.getUserDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("userList", userList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("userList", "result", userList);
	}
	@GetMapping(value = "/get_address_details")
	public ModelAndView getAddressDetails(@ModelAttribute UserAddressVo cmd,HttpServletRequest request) {
		UserAddressDto dto = new UserAddressDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserAddressDto> addressList = service.getAddressDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("addressList", addressList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("addressList", "result", addressList);
	}
	@GetMapping(value = "/get_permission_details")
	public ModelAndView getPermissionDetails(@ModelAttribute UserPermissionVo cmd,HttpServletRequest request) {
		UserPermissionDto dto = new UserPermissionDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserPermissionDto> permissionList = service.getPermissionDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("permissionList", permissionList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("permissionList", "result", permissionList);
	}
	@GetMapping(value = "/get_organization_details")
	public ModelAndView getOrganizationDetails(@ModelAttribute UserOrganizationVo cmd,HttpServletRequest request) {
		UserOrganizationDto dto = new UserOrganizationDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserOrganizationDto> organizationList = service.getOrganizationDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("organizationList", organizationList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("organizationList", "result", organizationList);
	}
}
