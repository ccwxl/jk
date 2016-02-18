package cn.wxl.jk.dao;

import java.util.Map;

import cn.wxl.jk.VO.ContractVO;
import cn.wxl.jk.domain.Contract;

public interface ContractDao extends BaseDao<Contract>  {
	public void updateState(Map map);
	public ContractVO view(String contractId);

}
