package cn.it.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven{  
	//用来装有将要被打包成json格式返回给前台的数据  
    protected List<T> jsonList = null;
	//
	protected String ids; 
	//输入流
    protected InputStream inputStream;  
	//page和rows和分页有关，pageMap存放查询的数据，然后打包成json格式用的  
    //page和rows实现get和set方法，pageMap只需要实现get方法即可，因为pageMap不是接收前台参数的，是让struts获取的  
	protected Integer page;  
    protected Integer rows;  
    protected Map<String, Object> pageMap = null;//让不同的Action自己去实现  
	//service对象  
	@Resource
    protected CategoryService categoryService; 
	@Resource
    protected AccountService accountService;  
    @Resource
    protected ProductService productService;
  
    //域对象   
    protected Map<String, Object> request;  
    protected Map<String, Object> session;  
    protected Map<String, Object> application;  
    protected T model;
      
    @Override  
    public void setApplication(Map<String, Object> application) {  
        this.application = application;  
    }  
  
    @Override  
    public void setSession(Map<String, Object> session) {  
        this.session = session;  
    }  
  
    @Override  
    public void setRequest(Map<String, Object> request) {  
        this.request = request;  
    }  
    
    @Override  
    public T getModel() { 
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();  
        Class clazz = (Class)type.getActualTypeArguments()[0];  
        try {  
            model = (T)clazz.newInstance();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }     
        return model;  
    }
    //set and get
	public Integer getPage() {
		return page;
	}
	public Integer getRows() {
		return rows;
	}
	public Map<String, Object> getPageMap() {
		return pageMap;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<T> getJsonList() {
		return jsonList;
	}
	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}  
    public void setCategoryService(CategoryService categoryService) {  
        this.categoryService = categoryService;  
    }  
    public void setAccountService(AccountService accountService) {  
        this.accountService = accountService;  
    }
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}  
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}  