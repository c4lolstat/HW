package com.epam.price;

import com.epam.product.Product;

import java.math.BigDecimal;

public class DiscountPriceCalculator implements PriceCalculator{

	@Override
	public BigDecimal price(Product product) {
		return product.getPrice().multiply(new BigDecimal("0.9"));
	}

}
