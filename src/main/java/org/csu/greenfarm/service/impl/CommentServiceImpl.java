package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.FarmComment;
import org.csu.greenfarm.persistence.FarmComMapper;
import org.csu.greenfarm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private FarmComMapper farmComMapper;

    @Override
    public List<Object> getCommentByItemId(String itemId) {
        List<Object> o = new ArrayList<>();
        List<FarmComment> farmComments = farmComMapper.getFarmCommentByFarmId(itemId);
        if(farmComments != null){
            for(int a = 0; a < farmComments.size(); a++){
                o.add(farmComments.get(a));
            }
        }
        return o;
    }

    @Override
    public List<Object> getCommentByUsername(String username) {
        List<Object> o = new ArrayList<>();
        List<FarmComment> farmComments = farmComMapper.getFarmCommentByUsername(username);
        if(farmComments != null){
            for(int a = 0; a < farmComments.size(); a++){
                o.add(farmComments.get(a));
            }
        }
        return o;
    }

    @Override
    public void insertComment(Object o) {
        if(o.getClass().getName().equals("org.csu.greenfarm.domain.FarmComment")){
            farmComMapper.insertFarmComment((FarmComment) o);
        }
    }
}
