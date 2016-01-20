package cn.wxl.jk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.wxl.jk.dao.BaseDao;
import cn.wxl.jk.dao.FactoryDao;
import cn.wxl.jk.domain.Factory;
import cn.wxl.jk.service.FactoryService;

@Service("factoryService")
public class FactoryServiceImpl extends BaseServiceImpl<Factory> implements
		FactoryService {
	
	@Resource
	@Qualifier("factoryDao")
	private FactoryDao factoryDao;
	
	@Resource(name = "factoryDao")
	public void setDao(BaseDao<Factory> dao) {
		super.setDao(dao);
	}
	
	public void insert(Factory factory) {
		factory.setId(UUID.randomUUID().toString());
		factoryDao.insert(factory);
	}

	// 启用一条或多条
	@SuppressWarnings("unused")
	public void updateStart(String[] ids) {
		Map map =new HashMap();
		map.put("state", 1);
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

	// 禁用一条或多条
	@SuppressWarnings("unused")
	public void updateStop(String[] ids) {
		Map map =new HashMap();
		map.put("state", 0);
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

	public List<Factory> getFactoryList() {
		//获取生产厂家,需要state是1
		Map map =new HashMap();
		map.put("state", 1);
		return factoryDao.find(map);
	}

}
