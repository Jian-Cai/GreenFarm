package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.ProductCom;

import java.util.List;

public interface ProductComMapper {
    List<ProductCom> getAllProductComment();//返回所有评论
    List<ProductCom> getProductCommentByUsername(String username);//根据账户返回pingl
    List<ProductCom> getProductCommentByProductId(String ProductId); //根据FarmId返回评论
    void insertProductComment(ProductCom productCom); //插入评论
}
