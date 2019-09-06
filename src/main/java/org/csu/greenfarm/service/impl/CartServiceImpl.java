package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.Cart;
import org.csu.greenfarm.domain.CartItem;
import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.persistence.CartItemMapper;
import org.csu.greenfarm.persistence.CartMapper;
import org.csu.greenfarm.persistence.FarmMapper;
import org.csu.greenfarm.persistence.ProductMapper;
import org.csu.greenfarm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private List<CartItem> productList;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CartItemMapper cartItemMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    FarmMapper farmMapper;

    @Override
    public List<CartItem> productList(String cartId) {
        productList = cartItemMapper.getCartItemByCartId(cartId);
        return productList;
    }

    @Override
    public Cart initCart(String account) {
        Cart cart = cartMapper.getCartByAccount(account);
        if(cart == null){
            cart.setAccount(account);
            cart.setCartId(account+1);
            cartMapper.initCart(cart);
            return cart;
        }
        return cart;
    }

    @Override
    public double getTotal(String cartId, String productId){
        double total = 0;
        String id = cartId + productId;
        CartItem cartItem = cartItemMapper.getCartItemById(id);
        if(productMapper.getProductByProductId(cartItem.getProductId())!=null) {
            Product product = productMapper.getProductByProductId(cartItem.getProductId());
            total = product.getProduct_price() * cartItem.getNum();
        }
        else{
            Farm farm = farmMapper.getFarmByFarmId(cartItem.getProductId());
            total = farm.getFarm_price() * cartItem.getNum();
        }
        return total;
    }

    @Override
    public double getAllTotal(String cartId) {
        double total = 0;
        productList = cartItemMapper.getCartItemByCartId(cartId);
        Iterator<CartItem> products = productList.iterator();
        while (products.hasNext()){
            CartItem cartItem = products.next();
            total += getTotal(cartId,cartItem.getProductId());
        }

        return total;
    }

    @Override
    public void addProduct(String cartId, String productId) {
        String id = cartId + productId;
        if (cartItemMapper.getCartItemById(id)==null){
        CartItem cartItem = new CartItem();
        cartItem.setId(id);
        cartItem.setCartId(cartId);
        cartItem.setNum(1);
        cartItem.setProductId(productId);
        cartItemMapper.insertCartItem(cartItem);
        }
        else {
            addNum(cartId,productId);
        }
    }

    @Override
    public void removeProduct(String cartId, String productId) {
        String id = cartId + productId;
        CartItem cartItem = cartItemMapper.getCartItemById(id);
        cartItemMapper.deleteCartItem(cartItem);
    }

    @Override
    public void addNum(String cartId, String productId) {
        String id = cartId + productId;
        CartItem cartItem = cartItemMapper.getCartItemById(id);
        int num = cartItem.getNum();
        cartItem.setNum(num+1);
        cartItemMapper.updateCartItem(cartItem);
    }

    @Override
    public void subNum(String cartId, String productId) {
        String id = cartId + productId;
        CartItem cartItem = cartItemMapper.getCartItemById(id);
        int num = cartItem.getNum();
        if(num == 1)
            removeProduct(cartId,productId);
        else {
            cartItem.setNum(num-1);
            cartItemMapper.updateCartItem(cartItem);
        }
    }
}
