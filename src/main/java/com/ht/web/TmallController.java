package com.ht.web;

import com.ht.bean.Comment;
import com.ht.bean.Product;
import com.ht.common.Contants;

import com.ht.common.Pager;
import com.ht.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2020/4/26.
 */
@Controller
@RequestMapping("/tmall")
public class TmallController {
    @Resource
    private IProductService is;

    //前台首页
    @RequestMapping("/index")
    public String index(Pager pager, Model model){
        pager.pageSize=2;
        //查询总行数
        pager.page(is.procount());
        pager.data=is.plistpage(pager);
        model.addAttribute("pager",pager);
        System.out.println("jinlaile");
        return "mall_index";
    }
    //后台列表
    @RequestMapping("/prolist")
    public String prolist(Model model){
        List<Product> plist = is.plist();
        System.out.println(plist.size());
        model.addAttribute("plist",plist);
        return "prolist";
    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "proadd";
    }

    @RequestMapping("/add")
    public String add(MultipartFile pfile,Product product) throws IOException {
        // 所以为每个文件生成一个新的文件名(asda-df43t-f34t3-23r2-34t2)
        String picName = UUID.randomUUID().toString();
        // 截取文件的扩展名(如.jpg)
        String oriName = pfile.getOriginalFilename();
        System.out.println("--上传文件名-->>"+oriName);
        // .png  .jpg
        String extName = oriName.substring(oriName.lastIndexOf("."));


        String dirName = Contants.PRO_IMG_SAVE_PATH;
        //创建文件夹
        File dirFile = new File(dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //拼接新文件名
        String newFileName = picName + extName;
        File targetFile = new File(dirName , newFileName);
        // 保存文件        pp.setPsrc("/img/"+newFileName);
        pfile.transferTo(targetFile);

        //保存图片名称到数据库
        product.setPimg("/pro/"+newFileName);
        product.setPcomment(0);

        //商品信息保存到数据库
        is.padd(product);
        return "redirect:prolist";
    }

    //查看商品详情
    @RequestMapping("/product")
    public String product(int id,Model model){
        Product product =  is.selprobyid(id);
        //根据商品ID查询评价内容
        List<Comment> commentList = is.selcommentbyid(id);
        model.addAttribute("pro",product);
        model.addAttribute("commentList",commentList);

        return "product";
    }


    @RequestMapping("/comment")
    public String comment(MultipartFile tp, Comment comment) throws IOException {
        // 所以为每个文件生成一个新的文件名(asda-df43t-f34t3-23r2-34t2)
        String picName = UUID.randomUUID().toString();
        // 截取文件的扩展名(如.jpg)
        String oriName = tp.getOriginalFilename();
        System.out.println("--上传文件名-->>"+oriName);
        // .png  .jpg
        String extName = oriName.substring(oriName.lastIndexOf("."));


        String dirName = Contants.COMMENT_IMG_SAVE_PATH;
        //创建文件夹
        File dirFile = new File(dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //拼接新文件名
        String newFileName = picName + extName;
        File targetFile = new File(dirName , newFileName);
        // 保存文件        pp.setPsrc("/img/"+newFileName);
        tp.transferTo(targetFile);

        //保存图片名称到数据库
        comment.setCimg("/comment/"+newFileName);

        //商品信息保存到数据库
        is.addcomment(comment);
        return "redirect:product?id="+comment.getPid();
    }
}
