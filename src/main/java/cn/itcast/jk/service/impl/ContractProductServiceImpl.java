package cn.itcast.jk.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.service.ContractProductService;

@Service("contractProductService")
public class ContractProductServiceImpl extends BaseServiceImpl<ContractProduct> implements ContractProductService {

	@Resource
	@Qualifier("contractProductDao")
	private ContractProductDao contractProductDao;
	
	@Resource(name="contractProductDao")
	public void setDao(BaseDao<ContractProduct> dao) {
		super.setDao(dao);
	}
	
	public void insert(ContractProduct contractProduct) {
		contractProduct.setId(UUID.randomUUID().toString());
		contractProductDao.insert(contractProduct);
	}
}
