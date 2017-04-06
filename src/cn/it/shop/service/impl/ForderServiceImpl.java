package cn.it.shop.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {
	 @Override  
    public double cluTotal(Forder forder) {  
  
        double total = 0.0;  
        for(Sorder sorder : forder.getSorders()) {  
            total += sorder.getNumber() * sorder.getPrice().longValueExact();  
        }  
        return total;  
    }
	 @Override
    public Forder test() {  
        String hql = "from Forder f ";  
        return (Forder) getSession().createQuery(hql)   
            .uniqueResult(); //返回一条记录:总记录数  
    }
}
