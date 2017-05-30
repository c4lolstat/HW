package com.epam.store;

import java.math.BigDecimal;

import com.epam.product.StoreProduct;
import com.epam.data.DataStore;
import com.epam.data.MemoryDataStore;
import com.epam.price.DiscountPriceCalculator;
import com.epam.price.ExclusivePriceCalculator;

public class Store {

	private DataStore<StoreProduct> memoryDataStore = new MemoryDataStore<StoreProduct>();
	private boolean exclusive;

	public Store() {
	}

	public Store(boolean exclusive) {
		this.exclusive = exclusive;
	}

	public void open() {
		memoryDataStore.add(new StoreProduct("Book", new BigDecimal("100")));
		memoryDataStore.add(new StoreProduct("UberLaptop", new BigDecimal("10000")));
	}

	public void printPrices() {
		for (StoreProduct product : memoryDataStore.list()) {
			BigDecimal price;
			if (exclusive) {
				price = new ExclusivePriceCalculator().price(product);
			} else {
				price = new DiscountPriceCalculator().price(product);
			}
			System.out.println(product.getName() + ": " + price);
		}
	}

	public BigDecimal stock() {
		BigDecimal sum = BigDecimal.ZERO;
		for (StoreProduct product : memoryDataStore.list()) {
			BigDecimal price;
			if (exclusive) {
				price = new ExclusivePriceCalculator().price(product);
			} else {
				price = new DiscountPriceCalculator().price(product);
			}
			sum = sum.add(price);
		}
		return sum;
	}

}
