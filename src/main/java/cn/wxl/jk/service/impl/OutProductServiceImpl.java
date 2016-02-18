package cn.wxl.jk.service.impl;

import cn.wxl.jk.VO.OutProductVO;
import cn.wxl.jk.dao.OutProductDao;
import cn.wxl.jk.service.OutProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/1/31.
 */
@Service("outProductService")
public class OutProductServiceImpl implements OutProductService {

    @Resource
    @Qualifier(value ="outProductDao")
    private OutProductDao outProductDao;


    public List<OutProductVO> find(String inputDate) {
        Map map=new HashMap();
        map.put("inputDate",inputDate);
        return outProductDao.find(map);
    }
}
