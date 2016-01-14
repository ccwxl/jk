package cn.itcast.jk.dao;

import java.util.Map;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.Factory;

public interface ContractDao extends BaseDao<Contract>  {
	public void updateState(Map map);
}
