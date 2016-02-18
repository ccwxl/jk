package cn.wxl.jk.service;

import cn.wxl.jk.VO.OutProductVO;

import java.util.List;

/**
 * Created by DELL on 2016/1/31.
 */
public interface OutProductService  {
    List<OutProductVO> find(String inputDate);
}
