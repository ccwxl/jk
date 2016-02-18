package cn.wxl.jk.dao.impl;

import cn.wxl.jk.VO.OutProductVO;
import cn.wxl.jk.dao.BaseDao;
import cn.wxl.jk.dao.OutProductDao;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 2016/1/31.
 */
@Repository("outProductDao")
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao{

    public OutProductDaoImpl() {
        super.setNs("cn.wxl.jk.mapper.OutProductMapper");
    }

}
