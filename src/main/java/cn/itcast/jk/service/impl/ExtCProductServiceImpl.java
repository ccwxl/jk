package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.dao.ExtCProductDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ExtCProduct;
import cn.itcast.jk.service.ExtCProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by DELL on 2016/1/20.
 */
@Service("extCProductService")
public class ExtCProductServiceImpl extends  BaseServiceImpl<ExtCProduct> implements ExtCProductService {

    @Resource
    @Qualifier("extCProductDao")
    private ExtCProductDao extCProductDao;

    @Resource(name = "extCProductDao")
    public void setDao(BaseDao<ExtCProduct> dao) {
        super.setDao(dao);
    }

    //增加
    public void insert(ExtCProduct extCProduct) {
        extCProduct.setId(UUID.randomUUID().toString());
        extCProductDao.insert(extCProduct);
    }


}
