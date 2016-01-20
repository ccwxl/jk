package cn.wxl.jk.service;

import java.util.List;

import cn.wxl.jk.domain.Factory;

public interface FactoryService extends BaseService<Factory> {
	void updateStart(String[] ids);
	void updateStop(String[] ids);
	List<Factory> getFactoryList();
}
