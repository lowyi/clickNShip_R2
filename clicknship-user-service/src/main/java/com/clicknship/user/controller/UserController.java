package com.clicknship.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clicknship.common.controller.BaseController;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.user.UserDTO;
import com.clicknship.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
@RefreshScope
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	@PostMapping("/create")
	public ResponseEntity<UserDTO> getCatalogue(@RequestBody(required = true) UserDTO user) throws BusinessException {
		return ResponseEntity.ok().body(userService.createUser(user));
	}

	@GetMapping("/detail/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId) throws BusinessException {
		return ResponseEntity.ok().body(userService.getUserById(userId));
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> logout() {
		deleteCookies();
		return ResponseEntity.ok().build();
	}

	private void deleteCookies() {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
	}
}
