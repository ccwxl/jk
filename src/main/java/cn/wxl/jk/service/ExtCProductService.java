package cn.wxl.jk.service;

import cn.wxl.jk.dao.SysCodeDao;
import cn.wxl.jk.domain.ExtCProduct;
import cn.wxl.jk.domain.SysCode;

import java.util.List;

/**
 * Created by DELL on 2016/1/20.
 */
public interface ExtCProductService extends  BaseService<ExtCProduct>  {

    List<SysCode> getCtypeList();
}
