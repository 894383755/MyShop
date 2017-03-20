package cn.it.shop.service;

import java.util.List;

public interface BaseService<T> { 
	/** 插入数据**/
    public void save(T t);  
    /**跟新数据**/
    public void update(T t);  
    /**删除数据**/
    public void delete(int id);  
    /**得到数据**/
    public T get(int id);  
    /**得到所有查询数据**/
    public List<T> query();  
}