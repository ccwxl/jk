package cn.itcast.jk.service;

import java.util.List;

import cn.itcast.jk.domain.Factory;

public interface FactoryService extends BaseService<Factory> {
	void updateStart(String[] ids);
	void updateStop(String[] ids);
	List<Factory> getFactoryList();
}
