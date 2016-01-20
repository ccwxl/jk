package cn.wxl.jk.dao.impl;

import java.util.Map;

import cn.wxl.jk.dao.FactoryDao;
import cn.wxl.jk.domain.Factory;
import org.springframework.stereotype.Repository;

@Repository("factoryDao")
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {
		public FactoryDaoImpl(){
			super.setNs("cn.wxl.jk.mapper.FactoryMapper");
		}

		@SuppressWarnings("unused")
		public void updateState(Map map) {
			super.getSqlSession().update(super.getNs()+".updateState", map);
		}

}
