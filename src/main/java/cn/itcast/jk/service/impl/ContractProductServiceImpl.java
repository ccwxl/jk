package cn.itcast.jk.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import cn.itcast.util.UtilFuns;
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
		//自动计算总金额=数量*单价		...修改，删除；同步合同总金额
		//TODO  计算价格
		if(UtilFuns.isNotEmpty(contractProduct.getCnumber()) && UtilFuns.isNotEmpty(contractProduct.getPrice())){
			contractProduct.setAmount(contractProduct.getCnumber()*contractProduct.getPrice());
		}
		contractProductDao.insert(contractProduct);
	}
}
