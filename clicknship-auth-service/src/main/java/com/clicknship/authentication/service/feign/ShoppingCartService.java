package com.clicknship.authentication.service.feign;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clicknship.authentication.service.feign.fallback.ShoppingCartServiceFallback;
import com.clicknship.model.cart.ShoppingCartDTO;

@FeignClient(value = "cart-service", fallback = ShoppingCartServiceFallback.class)
public interface ShoppingCartService {
	
	@GetMapping("/shoppingCart/shoppingCart/{userID}")
	ResponseEntity<ShoppingCartDTO> getShoppingCartByUserId(@PathVariable("userID") @NotNull Long userID);

}
