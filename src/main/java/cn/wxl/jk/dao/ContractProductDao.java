package cn.wxl.jk.dao;

import cn.wxl.jk.domain.ContractProduct;

import java.io.Serializable;

public interface ContractProductDao extends BaseDao<ContractProduct> {

    public void deleteContractProductById(Serializable ids[]);
}
