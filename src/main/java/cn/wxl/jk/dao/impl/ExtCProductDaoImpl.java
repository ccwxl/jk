package cn.wxl.jk.dao.impl;

import cn.wxl.jk.dao.ExtCProductDao;
import cn.wxl.jk.domain.ExtCProduct;
import cn.wxl.jk.service.ExtCProductService;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/1/20.
 */
@Repository("extCProductDao")
public class ExtCProductDaoImpl extends  BaseDaoImpl<ExtCProduct> implements ExtCProductDao {

    public  ExtCProductDaoImpl(){
        super.setNs("cn.wxl.jk.mapper.ExtCProductMapper");
    }

    @Override
    public List<ExtCProduct> find(Map map) {
        return getSqlSession().selectList(getNs()+".find",map);
    }

    public void deleteByContractProductById(Serializable[] ids) {
        getSqlSession().selectList(getNs()+".deleteByContractProductById",ids);
    }

    public void  deleteByContractIds(Serializable[] ids){
        getSqlSession().selectList(getNs()+".deleteByContractIds",ids);
    }
}
