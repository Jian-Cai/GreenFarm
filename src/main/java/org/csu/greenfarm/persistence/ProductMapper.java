package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> getAllProducts(); //返回所有的农产品
    Product getProductByProductId(String productId); //根据农产品ID返回相应农产品
    List<Product> getProductByProductName(String product_name); //根据农产品的名称返回相应农产品
    List<Product>  getProductByProductOrigin(String product_origin); //根据农场Id返回农产品
    List<Product> getProductByProductCate(String category); //根据种类返回产品
    void updateProduct(Product product);
    void pullProduct(String productId);
}
