package com.clicknship.catalogue.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotBlank
	@Column(name = "Name")
	private String name;

	@NotBlank
	@Column(name = "Description")
	private String description;

	@NotNull
	@Column(name = "Price")
	private BigDecimal price;

	@NotNull
	@Column(name = "Stock")
	private int stock;

	@NotNull
	@Column(name = "TB_USER_ID")
	private Long userId;

	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	private List<ProductImage> productImages;
	
	@OneToMany(mappedBy="product", fetch = FetchType.LAZY)
	private List<ProductReview> productReviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<ProductReview> getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(List<ProductReview> productReviews) {
		this.productReviews = productReviews;
	}

}
