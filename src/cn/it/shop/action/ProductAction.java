package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Product;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	static {
		System.out.println("进入productAction");
	}
	public String queryJoinCategory() {
		System.out.println("进入productAction_query");
		System.out.println("name:" + model.getName());
		System.out.println("page：" + page);
		System.out.println("rows：" + rows);
		
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		
		//根据关键字和分页的参数查询相应的数据
		List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList); //存储为JSON格式
		//根据关键字查询总记录数
		Long total = productService.getCount(model.getName());
		System.out.println(total);
		pageMap.put("total", total); //存储为JSON格式
		return "jsonMap";
	}
	public String deleteByIds() {  
        System.out.println(ids);  
        productService.deleteByIds(ids);  
        //如果删除成功就会往下执行，我们将"true"以流的形式传给前台  
        inputStream = new ByteArrayInputStream("true".getBytes());  
        return "stream";  
    } 
	 public void save() throws Exception {  
	        //处理上传的图片，下一篇博客专门分析struts2文件上传  
	          
	        model.setDate(new Date()); //设置一下当前时间，因为前台没有把时间字段传进来，这里自己设置一下即可  
	        System.out.println(model);  
	        //商品信息入库  
	        productService.save(model);  
	 }  
	 public void update() throws Exception {  
	        //处理上传的图片，下一篇博客专门分析struts2文件上传  
	          
	        model.setDate(new Date()); //设置一下当前时间，因为前台没有把时间字段传进来，这里自己设置一下即可  
	        System.out.println(model);  
	        //更新商品  
	        productService.update(model);  
	  }
}
