package test;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.spi.FilterTranslator;
import org.hibernate.hql.spi.QueryTranslatorFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.action.CategoryAction;
import cn.it.shop.action.ProductAction;
import cn.it.shop.model.Account;
import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
import cn.it.shop.service.impl.CategoryServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class TestMyShop {
	@Resource  
	private Date date;
	@Test //测试Hibernate的开发环境  
    public void springIoc() { 
        System.out.println(date);  
    } 
    
	@Test  //测试Hibernate的开发环境，因为没有整合，可以直接new 
    public void hihernate() { 
    	System.out.println("test : hihernate\n"); 
        CategoryService categoryService = new CategoryServiceImpl();  
        Category category = new Category(5,"男士休闲",true);  
        categoryService.update(category);
    } 
	@Test  //测试Hibernate的开发环境，直接分解测试哪里出错了，可以直接new 
    public void hihernate2(){
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
    	standardServiceRegistryBuilder.applySettings(configuration.getProperties());
    	SessionFactory sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
    	Session session = sessionFactory.openSession();
    	Transaction trans = session.beginTransaction();
    	Category category = new Category(10,"男士休闲",true);
    	session.save(category);
    	trans.commit();
    	session.close();
	}
	@Test //测试Hibernate和Spring整合后  
    public void hibernateAndSpring() { 
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	CategoryService service = (CategoryService)context.getBean("categoryService");
    	System.out.println(service.getClass().getName());
    	service.update(new Category(1,"测试",true));
    } 
	@Resource  
    private CategoryService categoryService;  
   
    @Test
    public void testQueryJoinAccount2() { 
        for(Category c : categoryService.queryJoinAccount("",1,2)) { //显示第一页，每页2条数据  
            System.out.println(c + "," + c.getAccount());  
        }  
    }
    @Resource  
    private ProductService productService;  
    
    @Test
    public void testQueryJoinAccount3() { 
    	for(Product c : productService.queryJoinCategory("",1,2)) { //显示第一页，每页2条数据  
    		System.out.println(c + "," + c.getName());  
    	}  
    }

}
