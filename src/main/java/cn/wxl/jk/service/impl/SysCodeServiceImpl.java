package cn.wxl.jk.service.impl;

import cn.wxl.jk.dao.BaseDao;
import cn.wxl.jk.dao.SysCodeDao;
import cn.wxl.jk.domain.SysCode;
import cn.wxl.jk.service.SysCodeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/1/30.
 */
@Service("sysCodeService")
public class SysCodeServiceImpl extends  BaseServiceImpl<SysCode> implements SysCodeService {

    @Resource
    @Qualifier("sysCodeDao")
    private SysCodeDao sysCodeDao;

    @Resource(name = "sysCodeDao")
    public void setDao(BaseDao<SysCode> dao) {
        super.setDao(dao);
    }

    @Override
    public List<SysCode> find(Map paraMap) {
        return sysCodeDao.find(paraMap);
    }
}
