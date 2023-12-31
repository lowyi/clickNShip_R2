package com.clicknship.cart.service.feign;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clicknship.cart.service.feign.fallback.CatalogueServiceFallback;
import com.clicknship.model.product.ProductDTO;

@FeignClient(value = "catalogue-service", fallback = CatalogueServiceFallback.class)
public interface CatalogueService {
	
	@GetMapping("/catalogue/product/{id}")
	ResponseEntity<ProductDTO> getProductById(@PathVariable("id") @NotNull Long id);

}
