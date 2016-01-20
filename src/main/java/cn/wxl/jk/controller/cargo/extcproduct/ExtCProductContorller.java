package cn.wxl.jk.controller.cargo.extcproduct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 2016/1/20.
 */
@Controller
@RequestMapping("/cargo/extcproduct/")
public class ExtCProductContorller {


    /**增加附件*/
    @RequestMapping("tocreate.action")
    public  String tocreate(String id,String contractId,Model model){

        return "";
    }
}
