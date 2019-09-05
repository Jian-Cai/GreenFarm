package org.csu.greenfarm.service;

import org.csu.greenfarm.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts(); //返回所有的农产品
    Product getProductByProductId(String productId); //根据农产品ID返回相应农产品
    List<Product> getProductByProductName(String product_name); //根据农产品的名称返回相应农产品
    List<Product>  getProductByProductOrigin(String product_origin); //根据农场Id返回农产品
}
