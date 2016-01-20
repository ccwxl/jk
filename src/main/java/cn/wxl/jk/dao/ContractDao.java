package cn.wxl.jk.dao;

import java.util.Map;

import cn.wxl.jk.domain.Contract;

public interface ContractDao extends BaseDao<Contract>  {
	public void updateState(Map map);
}
