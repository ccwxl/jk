package cn.wxl.jk.controller.cargo.extcproduct;

import cn.wxl.jk.domain.ExtCProduct;
import cn.wxl.jk.service.ExtCProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by DELL on 2016/1/20.
 */
@Controller
@RequestMapping("/cargo/extcproduct/")
public class ExtCProductContorller {

    @Resource
    @Qualifier("extCProductService")
    private ExtCProductService extCProductService;

    /**增加附件*/
    @RequestMapping("tocreate.action")
    public  String tocreate(String id,String contractId,Model model){

        return "";
    }
    @RequestMapping("create.action")
    public String  create(ExtCProduct extCProduct){
        extCProductService.insert(extCProduct);
        return "";
    }
}
