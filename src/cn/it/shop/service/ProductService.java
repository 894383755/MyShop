package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Product;

public interface ProductService extends BaseService<Product> {
	/**
	 * 查询product的级联信息
	 * @param name 名字
	 * @param page 页数
	 * @param size 数量
	 * @return
	 */
	public List<Product> queryJoinCategory(String name, int page, int size);
	/**
	 * 根据关键字进行查询
	 * @param type 关键字
	 * @return
	 */
	public Long getCount(String type);
}
