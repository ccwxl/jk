package cn.wxl.jk.dao.impl;

import cn.wxl.jk.domain.ExtCProduct;
import cn.wxl.jk.service.ExtCProductService;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 2016/1/20.
 */
@Repository("extCProductDao")
public class ExtCProductDaoImpl extends  BaseDaoImpl<ExtCProduct> implements ExtCProductService {

    public  ExtCProductDaoImpl(){
        super.setNs("cn.itcast.jk.mapper.ExtCProductMapper");
    }


}
