package cn.itcast.jk.dao.impl;


import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.domain.ContractProduct;

@Repository("contractProductDao")
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {
		public ContractProductDaoImpl(){
			super.setNs("cn.itcast.jk.mapper.ContractProductMapper");
		}

}
