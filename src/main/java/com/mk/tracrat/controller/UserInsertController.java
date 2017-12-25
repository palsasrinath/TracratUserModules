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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// home page for getting details form
	@GetMapping("/getbyid_users_details")
	public ModelAndView getUsersByid() {
		return new ModelAndView("GetDetailsById_Home");
	}

	// search user by id in database
	@GetMapping("/getbyid_user_details")
	public ModelAndView searchUserByid() {
		return new ModelAndView("searchUserByid");
	}

	@GetMapping("/getbyid_organization_details")
	public ModelAndView searchOrgByid() {
		return new ModelAndView("searchOrgByid");
	}

	@GetMapping("/getbyid_role_details")
	public ModelAndView searchRoleByid() {
		return new ModelAndView("searchRoleByid");
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
	public ModelAndView getUserDetails(@ModelAttribute UserVo cmd, HttpServletRequest request) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserDto> userList = service.getUserDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("userList", userList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("userList", "result", userList);
	}

	@GetMapping(value = "/get_address_details")
	public ModelAndView getAddressDetails(@ModelAttribute UserAddressVo cmd, HttpServletRequest request) {
		UserAddressDto dto = new UserAddressDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserAddressDto> addressList = service.getAddressDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("addressList", addressList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("addressList", "result", addressList);
	}

	@GetMapping(value = "/get_permission_details")
	public ModelAndView getPermissionDetails(@ModelAttribute UserPermissionVo cmd, HttpServletRequest request) {
		UserPermissionDto dto = new UserPermissionDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserPermissionDto> permissionList = service.getPermissionDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("permissionList", permissionList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("permissionList", "result", permissionList);
	}

	@GetMapping(value = "/get_organization_details")
	public ModelAndView getOrganizationDetails(@ModelAttribute UserOrganizationVo cmd, HttpServletRequest request) {
		UserOrganizationDto dto = new UserOrganizationDto();
		BeanUtils.copyProperties(cmd, dto);
		List<UserOrganizationDto> organizationList = service.getOrganizationDetails(dto);
		HttpSession session = request.getSession();
		session.setAttribute("organizationList", organizationList);
		// String json = JsonUtil.javaToJson(result);
		return new ModelAndView("organizationList", "result", organizationList);
	}

	@GetMapping("/get_user_role")
	public ModelAndView getRoleDetails(HttpServletRequest req) {
		UserRoleDto dto = new UserRoleDto();
		List<UserRoleDto> roleList = service.getRoleDetails(dto);
		HttpSession session = req.getSession();
		session.setAttribute("roleList", roleList);
		System.out.println("session   " + roleList);
		return new ModelAndView("roleList", "role", roleList);
	}

	// Get userDetails by id
	@PostMapping("/user_get_id")
	public ModelAndView getUserDetailsById(@RequestParam int user_id, HttpServletRequest req) {
		System.out.println("controller    " + user_id);
		List<UserDto> ListUser = service.getUser(user_id);
		HttpSession session = req.getSession();
		System.out.println("session user  " + ListUser);
		session.setAttribute("ListUser", ListUser);
		return new ModelAndView("ListUserById", "result", ListUser);

	}

	// get userOrgDetails ById
	@PostMapping("/org_get_id")
	public ModelAndView getOrgDetailsByid(@RequestParam int org_id, HttpServletRequest req) {
		System.out.println("controller   " + org_id);
		List<UserOrganizationDto> orgDto = service.getOrganizationDetails(org_id);
		HttpSession session = req.getSession();
		session.setAttribute("orgDto", orgDto);
		System.out.println("controller res  " + orgDto);
		return new ModelAndView("ListOrgByid", "orgDto", orgDto);
	}

	@PostMapping("/role_get_id")
	public ModelAndView getRoleDetaqilsByid(@RequestParam int role_id, HttpServletRequest req) {
		System.out.println("controller req "+role_id);
		List<UserRoleDto> roleDto = service.getRoleDetails(role_id);
		HttpSession session = req.getSession();
		session.setAttribute("roleDto", roleDto);
		System.out.println("controller res  "+roleDto);
		return new ModelAndView("ListRoleByid", "roleDto", roleDto);
	}
}
