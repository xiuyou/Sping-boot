package com.ht.dao;

import com.ht.bean.Comment;
import com.ht.bean.Product;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2020/4/26.
 */
@Repository
@Transactional
public interface ProductDao {
    List<Product> selpros();
    void addpro(Product product);
    int selprocount();
    List<Product> selprobypage(@Param("startRow") int startRow, @Param("pageSize") int pageSize);
    Product selprobyid(int id);

    void addcomment(Comment comment);
    //根据商品ID查评价的方法
    List<Comment> selcommentbyid(int pid);

}
