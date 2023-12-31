package com.clicknship.model.cart;

import javax.validation.constraints.NotNull;

import com.clicknship.model.product.ProductDTO;

public class ShoppingCartProductDTO {

	private Long id;

	@NotNull
	private Long shoppingCartId;

	@NotNull
	private int quantity;

	@NotNull
	private ProductDTO product;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
