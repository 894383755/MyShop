package cn.it.shop.service;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.it.shop.model.Category;

public interface CategoryService{
	public void save(Category category); //用来测试Hibernate环境  
	public void update(Category category);//测试spring和hibernate
}
