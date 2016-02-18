package cn.wxl.jk.dao.impl;

import cn.wxl.jk.dao.SysCodeDao;
import cn.wxl.jk.domain.SysCode;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 2016/1/30.
 */
@Repository("sysCodeDao")
public class SysCodeDaoImpl extends  BaseDaoImpl<SysCode> implements SysCodeDao {

    public SysCodeDaoImpl() {
        //设置命名空间
        super.setNs("cn.wxl.jk.mapper.SysCodeMapper");
    }



}
