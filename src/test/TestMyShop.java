package test;


import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;

//@ContextConfiguration(locations="classpath:beans.xml")
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
        Category category = new Category(5,"男士休闲");  
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
    	Category category = new Category(10,"男士休闲");
    	session.save(category);
    	trans.commit();
    	session.close();
	}
    @Test //测试Hibernate和Spring整合后  
    public void hibernateAndSpring() { 
    	//categoryService.update(new Category(3,"休闲女式")); //categoryService通过Spring从上面注入进来的  
    } 
}
