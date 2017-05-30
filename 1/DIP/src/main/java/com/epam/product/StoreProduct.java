package com.epam.product;

import java.math.BigDecimal;

public final class StoreProduct implements Product{

	private final String name;

	private final BigDecimal price;

	public StoreProduct(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

}
