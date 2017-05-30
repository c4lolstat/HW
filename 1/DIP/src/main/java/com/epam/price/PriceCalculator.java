package com.epam.price;

import com.epam.product.Product;

import java.math.BigDecimal;

/**
 * Created by Zoltan_Biro on 5/24/2017.
 */
public interface PriceCalculator {
    public BigDecimal price(Product product);
}
