package cn.itcast.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.Factory;

@Repository("contractDao")
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {
		public ContractDaoImpl(){
			super.setNs("cn.itcast.jk.mapper.ContractMapper");
		}

		public void updateState(Map map) {
			super.getSqlSession().update(super.getNs()+".updateState", map);
		}
}