package org.csu.greenfarm.domain;

import org.csu.greenfarm.persistence.ProductMapper;
import org.csu.greenfarm.service.ProductService;
import org.csu.greenfarm.service.impl.FarmServiceImpl;
import org.csu.greenfarm.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class CartItem implements Serializable {
    private String id;
    private String cartId;
    private String productId;
    private int num;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }



    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id=id;
    }



    public int getNum() {
        return num;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setNum(int num) {
        this.num = num;
    }



}
