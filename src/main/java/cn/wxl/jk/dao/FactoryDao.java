package cn.wxl.jk.dao;

import java.util.Map;

import cn.wxl.jk.domain.Factory;

public interface FactoryDao extends BaseDao<Factory>  {
	public void updateState(Map map);

}
