package cn.it.shop.service;

import org.springframework.stereotype.Service;

import cn.it.shop.model.User;

@Service("userService") 
public interface UserService extends BaseService<User>{
	/**
	 * 用户登陆，成功返回该User  
	 * @param user
	 * @return
	 */
    public User login(User user);
}
