package cn.it.shop.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.utils.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService {
	 
    /*Spring和Hibernate整个后*/  
    private SessionFactory sessionFactory; //定义一个sessionFactory  
	
	@Override //没有和Spring整合的情况  
	    public void save(Category category) {  
	        //通过刚刚生成的sessionFactory获取session  
	        Session session = HibernateSessionFactory.getSession();  
	        try {  
	            //手动事务  
	            session.getTransaction().begin();  
	            //执行业务逻辑  
	            session.save(category);  
	            //手动提交  
	            session.getTransaction().commit();  
	        } catch(Exception e) {  
	            session.getTransaction().rollback();  
	            throw new RuntimeException(e);  
	        } finally {  
	            HibernateSessionFactory.closeSession();  
	        }         
	    }
		@Override
	    public void update(Category category) { 
	        getSession().save(category);    
	        System.out.println("返回");
	    }
	    public void setSessionFactory(SessionFactory sessionFactory) {  
	        this.sessionFactory = sessionFactory;  
	    }    

	    protected Session getSession() { 
	    	System.out.println("进入");
	    	System.out.println(sessionFactory);
	        //从当前线程获取session，如果没有则创建一个新的session 
//	    	return sessionFactory.openSession();
	        return sessionFactory.getCurrentSession();  
	    }  
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}



}
