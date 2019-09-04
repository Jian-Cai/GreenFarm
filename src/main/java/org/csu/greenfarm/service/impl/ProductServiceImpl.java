package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.persistence.ProductMapper;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAllProducts() {
        return mapper.getAllProducts();
    }

    @Override
    public Product getProductByProductId(String productId) {
        return mapper.getProductByProductId(productId);
    }

    @Override
    public Product getProductByProductName(String product_name) {
        return mapper.getProductByProductName(product_name);
    }

    @Override
    public List<Product> getProductByProductOrigin(String product_origin) {
        return mapper.getProductByProductOrigin(product_origin);
    }
}
