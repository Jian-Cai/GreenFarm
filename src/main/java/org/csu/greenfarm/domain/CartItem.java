package org.csu.greenfarm.domain;

import java.io.Serializable;

public class CartItem implements Serializable {
    private static final long serialVersionUID = 6620528781626504362L;
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
