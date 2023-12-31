package com.clicknship.catalogue.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import com.clicknship.common.exception.BusinessException;
import com.clicknship.model.cart.ShoppingCartProductDTO;
import com.clicknship.model.product.ProductDTO;
import com.clicknship.model.product.ProductRatingsDTO;
import com.clicknship.model.product.ProductReviewDTO;
import com.clicknship.model.product.ProductSearchDTO;

public interface CatalogueService {

	List<ProductDTO> getCatalogue();

	Optional<ProductDTO> getProductById(Long id);

	Page<ProductDTO> searchProducts(ProductSearchDTO searchDTO, Pageable page);

	Page<ProductDTO> getRecommendedProductsByRatings(Pageable page);
	
	String uploadImage(MultipartFile file) throws BusinessException, IOException;

	ProductDTO createCatalogue(ProductDTO product);
	
	Page<ProductReviewDTO> getProductReviews(Long id, Pageable page);
	
	ProductRatingsDTO getProductRatings(Long id);
	
	ProductReviewDTO addProductReview(ProductReviewDTO review);
	
	void deductProductStockById(Long id, ShoppingCartProductDTO product) throws BusinessException;
	
	void returnProductStockById(Long id, int quantity) throws BusinessException;
}
