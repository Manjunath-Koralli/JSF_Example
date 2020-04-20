package com.shop.product;

import java.util.List;

public interface ProductService {
	List<Product> getPopularProducts();

    Product getProduct(long id);
}
