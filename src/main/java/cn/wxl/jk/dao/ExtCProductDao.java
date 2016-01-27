package cn.wxl.jk.dao;

import cn.wxl.jk.domain.ExtCProduct;

import java.io.Serializable;

/**
 * Created by DELL on 2016/1/20.
 */
public interface ExtCProductDao extends  BaseDao<ExtCProduct>  {

    public void deleteByContractProductById(Serializable[] ids);
    public void  deleteByContractIds(Serializable[] ids);

}
