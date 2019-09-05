package org.csu.greenfarm.service;

import org.csu.greenfarm.domain.Cart;
import org.csu.greenfarm.domain.CartItem;

import java.util.List;

public interface CartService {
    Cart initCart(String account);
    List<CartItem> productList(String cartId);
    double getTotal(String cartId,String productId);
    double getAllTotal(String cartId);
    void addProduct(String cartId,String productId);
    void removeProduct(String cartId,String productId);
    void addNum(String cartId,String productId);
    void subNum(String cartId,String productId);
}
