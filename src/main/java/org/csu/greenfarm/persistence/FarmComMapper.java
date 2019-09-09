package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.FarmComment;

import java.util.List;

public interface FarmComMapper {
    List<FarmComment> getAllFarmComment();//返回所有评论
    List<FarmComment> getFarmCommentByUsername(String username);//根据账户返回pingl
    List<FarmComment> getFarmCommentByFarmId(String FarmId); //根据FarmId返回评论
    void insertFarmComment(FarmComment farmComment); //插入评论
}
