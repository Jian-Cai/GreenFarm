package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.Cart;

public interface CartMapper {
    Cart getCartByAccount(String account);
    Cart getCartByCartId(String id);
    void initCart(Cart cart);
}
