package cn.itcast.jk.service;

import cn.itcast.jk.domain.Contract;

public interface ContractService extends BaseService<Contract> {
	void updateStart(String[] ids);
	void updateStop(String[] ids);

}
