package com.ht.service.impl;

import com.ht.bean.Comment;
import com.ht.bean.Product;
import com.ht.common.Pager;
import com.ht.dao.ProductDao;
import com.ht.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2020/4/26.
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductDao productDao;
    @Override
    public List<Product> plist() {
        return productDao.selpros();
    }

    @Override
    public void padd(Product product) {
        productDao.addpro(product);
    }

    @Override
    public int procount() {
        return productDao.selprocount();
    }

    @Override
    public List<Product> plistpage(Pager pager) {
        return productDao.selprobypage((pager.currPage-1)*pager.pageSize,pager.pageSize);
    }

    @Override
    public Product selprobyid(int id) {
        return productDao.selprobyid(id);
    }

    @Override
    public void addcomment(Comment comment) {
        productDao.addcomment(comment);
    }

    @Override
    public List<Comment> selcommentbyid(int pid) {
        return productDao.selcommentbyid(pid);
    }
}
