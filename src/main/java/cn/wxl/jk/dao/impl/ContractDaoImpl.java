package cn.wxl.jk.dao.impl;

import java.util.Map;

import cn.wxl.jk.VO.ContractVO;
import org.springframework.stereotype.Repository;

import cn.wxl.jk.dao.ContractDao;
import cn.wxl.jk.domain.Contract;

@Repository("contractDao")
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {
		public ContractDaoImpl(){
			super.setNs("cn.wxl.jk.mapper.ContractMapper");
		}

		public void updateState(Map map) {
			super.getSqlSession().update(super.getNs()+".updateState", map);
		}

	public ContractVO view(String contractId) {
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}
}
