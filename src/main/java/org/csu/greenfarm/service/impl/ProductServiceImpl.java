package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.Check;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.persistence.CheckMapper;
import org.csu.greenfarm.persistence.ProductMapper;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;
    @Autowired
    private CheckMapper checkMapper;

    @Override
    public List<Product> getAllProducts() {
        return mapper.getAllProducts();
    }

    @Override
    public Product getProductByProductId(String productId) {
        return mapper.getProductByProductId(productId);
    }

    @Override
    public List<Product> getProductByProductName(String product_name) {
        return mapper.getProductByProductName("%"+product_name+"%");
    }

    @Override
    public void putProduct(String productId, String product_check ,String result) {
        Check check = new Check();
        check.setCheckId(product_check);
        check.setCheck_item(mapper.getProductByProductId(productId).getProduct_name());
        check.setCheck_origin(mapper.getProductByProductId(productId).getProduct_origin());
        check.setCheck_date(new Date());
        check.setCheck_result(result);
        checkMapper.insertCheckItem(check);
        Product product = mapper.getProductByProductId(productId);
        product.setProduct_check(product_check);
        mapper.updateProduct(product);
    }

    @Override
    public void pullProduct(String productId) {
        String checkId = mapper.getProductByProductId(productId).getProduct_check();
        mapper.pullProduct(productId);
        checkMapper.deleteCheckItem(checkId);

    }

    @Override
    public List<Product> getProductByProductOrigin(String product_origin) {
        return mapper.getProductByProductOrigin(product_origin);
    }

    @Override
    public List<Product> getProductByProductCate(String category) {
        return mapper.getProductByProductCate(category);
    }
}
