package cn.wxl.jk.dao.impl;


import cn.wxl.jk.dao.ContractProductDao;
import cn.wxl.jk.domain.ContractProduct;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("contractProductDao")
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {
		public ContractProductDaoImpl(){
			super.setNs("cn.wxl.jk.mapper.ContractProductMapper");
		}
	 public void deleteContractProductById(Serializable ids[]){
		 getSqlSession().delete(getNs()+".deleteContractProductById",ids);
	 }
}
