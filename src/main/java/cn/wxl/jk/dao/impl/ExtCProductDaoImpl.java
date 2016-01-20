package cn.wxl.jk.dao.impl;

import cn.wxl.jk.dao.ExtCProductDao;
import cn.wxl.jk.domain.ExtCProduct;
import cn.wxl.jk.service.ExtCProductService;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 2016/1/20.
 */
@Repository("extCProductDao")
public class ExtCProductDaoImpl extends  BaseDaoImpl<ExtCProduct> implements ExtCProductDao {

    public  ExtCProductDaoImpl(){
        super.setNs("cn.wxl.jk.mapper.ExtCProductMapper");
    }


}
