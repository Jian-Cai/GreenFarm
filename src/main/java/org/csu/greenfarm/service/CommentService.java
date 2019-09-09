package org.csu.greenfarm.service;

import java.util.List;

public interface CommentService {
    List<Object> getCommentByItemId(String itemId);//根据项目Id返回评论
    List<Object> getCommentByUsername(String username); //根据account返回评论
    void insertComment(Object o);
}
