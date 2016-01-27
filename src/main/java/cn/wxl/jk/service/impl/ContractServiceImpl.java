package cn.wxl.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import cn.wxl.jk.dao.ContractProductDao;
import cn.wxl.jk.dao.ExtCProductDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.wxl.jk.dao.BaseDao;
import cn.wxl.jk.dao.ContractDao;
import cn.wxl.jk.domain.Contract;
import cn.wxl.jk.service.ContractService;

@Service("contractService")
public class ContractServiceImpl extends BaseServiceImpl<Contract> implements ContractService {
	
	@Resource
	@Qualifier("contractDao")
	private ContractDao contractDao;
	
	@Resource(name = "contractDao")
	public void setDao(BaseDao<Contract> dao) {
		super.setDao(dao);
	}

	@Resource(name="contractProductDao")
	private ContractProductDao contractProductDao;

	@Resource(name="extCProductDao")
	private ExtCProductDao extCProductDao;

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
	@Override
	public void deleteById(Serializable id) {
		Serializable [] ids ={id};
		extCProductDao.deleteByContractIds(ids);		//删除货物下的附件用子查询来删除,
		contractProductDao.deleteContractProductById(ids);//删除合同下的货物,从字表往主表删除
		contractDao.deleteById(id);
	}
	@Override
	public void delete(Serializable[] ids) {
		extCProductDao.deleteByContractIds(ids);		//删除货物下的附件用子查询来删除,
		contractProductDao.deleteContractProductById(ids);//删除合同下的货物
		contractDao.delete(ids);
	}


}
