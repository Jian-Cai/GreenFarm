package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.CartItem;

import java.util.List;

public interface CartItemMapper {
    CartItem getCartItemById(String id);
    List<CartItem> getCartItemByCartId(String cartId);
    void insertCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void deleteCartItem(CartItem cartItem);
}
