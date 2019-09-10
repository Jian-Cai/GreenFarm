package org.csu.greenfarm.domain;

import java.io.Serializable;

public class Cart implements Serializable {
    private String CartId;
    private String account;

    public String getCartId() {
        return CartId;
    }

    public void setCartId(String cartId) {
        CartId = cartId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String Account) {
        account = Account;
    }

}
