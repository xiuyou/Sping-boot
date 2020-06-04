package com.ht.service;

import com.ht.bean.Comment;
import com.ht.bean.Product;
import com.ht.common.Pager;

import java.util.List;

/**
 * Created by Administrator on 2020/4/26.
 */
public interface IProductService {
    public List<Product> plist();
    public void padd(Product product);
    public int procount();
    public List<Product> plistpage(Pager pager);
    public Product selprobyid(int id);

    public void addcomment(Comment comment);
    public List<Comment> selcommentbyid(int pid);
}
