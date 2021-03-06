package com.shop.product;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class PopularProducts {
	
	@Inject
	private ProductService productService;

    private List<Product> products;
    
    //@Post Construct - calls the method after bean creation
    @PostConstruct
    public void initialize() {
        products = productService.getPopularProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

}
