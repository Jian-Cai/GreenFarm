package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.FarmComment;
import org.csu.greenfarm.domain.ProductCom;
import org.csu.greenfarm.persistence.FarmComMapper;
import org.csu.greenfarm.persistence.ProductComMapper;
import org.csu.greenfarm.persistence.ProductMapper;
import org.csu.greenfarm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private FarmComMapper farmComMapper;

    @Autowired
    private ProductComMapper productComMapper;

    @Override
    public List<Object> getCommentByItemId(String itemId) {
        List<Object> o = new ArrayList<>();
        List<FarmComment> farmComments = farmComMapper.getFarmCommentByFarmId(itemId);
        List<ProductCom> productComs = productComMapper.getProductCommentByProductId(itemId);
        if(farmComments.size() != 0){
            for(int a = 0; a < farmComments.size(); a++){
                o.add(farmComments.get(a));
            }
        }
        else {
            for(int a = 0; a < productComs.size(); a++){
                o.add(productComs.get(a));
            }
        }
        return o;
    }

    @Override
    public List<Object> getCommentByUsername(String username) {
        List<Object> o = new ArrayList<>();
        List<FarmComment> farmComments = farmComMapper.getFarmCommentByUsername(username);
        List<ProductCom> productComs = productComMapper.getProductCommentByUsername(username);
        if(farmComments.size() != 0){
            for(int a = 0; a < farmComments.size(); a++){
                o.add(farmComments.get(a));
            }
        }
        if(productComs.size() != 0){
            for(int a = 0; a < productComs.size(); a++){
                o.add(productComs.get(a));
            }
        }
        return o;
    }

    @Override
    public void insertComment(Object o) {
        if(o.getClass().getName().equals("org.csu.greenfarm.domain.FarmComment")){
            farmComMapper.insertFarmComment((FarmComment) o);
        }
        if(o.getClass().getName().equals("org.csu.greenfarm.domain.ProductCom")){
            productComMapper.insertProductComment((ProductCom) o);
        }
    }
}
