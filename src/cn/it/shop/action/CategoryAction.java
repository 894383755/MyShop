package cn.it.shop.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;

public class CategoryAction extends ActionSupport { 
	
	private Category category;//设置一个私有成员变量接收url带过来的参数，注意下面要写好get和set方法 
    private CategoryService categoryService; //设置categoryService是为了很直观的看出与Spring整合前后的不同  
      

    public String update() {  
        System.out.println("----update----");  
        System.out.println(category.getType());
        System.out.println(category.getId());
        category.setId(20);
        System.out.println(categoryService);
        categoryService.update(category);
        return "index";  
    }  
      
    public String save() {  
        System.out.println("----save----");  
        System.out.println(categoryService);//整合前后输出不同  
        categoryService.save(category);
        System.out.println("完成");
        return "index";  
    }
    
    public void setCategoryService(CategoryService categoryService) { 
        this.categoryService = categoryService;  
    }  
      
	public Category getCategory() {
		return category;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategory(Category category) {
		this.category = category;
	}  
}  