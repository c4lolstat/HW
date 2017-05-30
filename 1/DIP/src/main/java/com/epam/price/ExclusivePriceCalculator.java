package com.epam.price;

import com.epam.product.Product;

import java.math.BigDecimal;

public class ExclusivePriceCalculator implements PriceCalculator{

	@Override
	public BigDecimal price(Product product) {
		return product.getPrice().multiply(new BigDecimal("2"));
	}

}
