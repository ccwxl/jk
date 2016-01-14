package cn.itcast.jk.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.service.FactoryService;

@Service("contractService")
public class ContractServiceImpl extends BaseServiceImpl<Contract> implements ContractService {
	
	@Resource
	@Qualifier("contractDao")
	private ContractDao contractDao;
	
	@Resource(name = "contractDao")
	public void setDao(BaseDao<Contract> dao) {
		super.setDao(dao);
	}
	
	public void insert(Contract contract) {
		contract.setId(UUID.randomUUID().toString());
		contractDao.insert(contract);
	}

	// 启用一条或多条
	public void updateStart(String[] ids) {
		Map map =new HashMap();
		map.put("state", 1);
		map.put("ids", ids);
		contractDao.updateState(map);
	}

	// 禁用一条或多条
	public void updateStop(String[] ids) {
		Map map =new HashMap();
		map.put("state", 0);
		map.put("ids", ids);
		contractDao.updateState(map);
	}

}
