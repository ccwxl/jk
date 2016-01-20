package cn.wxl.jk.service;

import cn.wxl.jk.domain.Contract;

public interface ContractService extends BaseService<Contract> {
	void updateStart(String[] ids);
	void updateStop(String[] ids);

}
