package com.clicknship.catalogue.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clicknship.catalogue.service.feign.fallback.UserServiceFallback;
import com.clicknship.model.user.UserDTO;

@FeignClient(value = "user-service", fallback = UserServiceFallback.class)
public interface UserService {
	
	@GetMapping("/user/detail/{userId}")
	ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId);

}
