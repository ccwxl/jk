package cn.wxl.jk.dao.impl;


import cn.wxl.jk.dao.ContractProductDao;
import cn.wxl.jk.domain.ContractProduct;
import org.springframework.stereotype.Repository;

@Repository("contractProductDao")
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {
		public ContractProductDaoImpl(){
			super.setNs("cn.itcast.jk.mapper.ContractProductMapper");
		}

}
