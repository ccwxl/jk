package cn.wxl.jk.controller.cargo.extcproduct;

import cn.wxl.jk.domain.ExtCProduct;
import cn.wxl.jk.domain.Factory;
import cn.wxl.jk.service.ExtCProductService;
import cn.wxl.jk.service.FactoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/1/20.
 */
@Controller
@RequestMapping("/cargo/extcproduct/")
public class ExtCProductContorller {

    @Resource
    @Qualifier("extCProductService")
    private ExtCProductService extCProductService;

    @Resource
    @Qualifier("factoryService")
    private FactoryService factoryService ;

    /**增加附件*/
    @RequestMapping("tocreate.action")
    public  String tocreate(String contractProductId,Model model){
        model.addAttribute("contractProductId",contractProductId);

        //某个货物下的附件信息
        Map paraMap = new HashMap();
        paraMap.put("contractProductId", contractProductId);
        List<ExtCProduct> dataList =extCProductService.find(paraMap);
        model.addAttribute("dataList", dataList);

        //获取所有的厂家
        List<Factory> factoryList  =factoryService.getFactoryList();
        model.addAttribute("factoryList",factoryList);
        //获取所有的分类
        //List<> extCProductService.getCtypeList();

        return "/cargo/contract/jExtCproductCreate.jsp";
    }
    @RequestMapping("insert.action")
    public String  create(ExtCProduct extCProduct,Model model){
        extCProductService.insert(extCProduct);
        model.addAttribute("contractProductId",extCProduct.getContractProductId());

        return "redirect:/cargo/extcproduct/tocreate.action";
    }

    @RequestMapping("toupdate.action")
    public String toUpdate(String id ,Model model){
        ExtCProduct extCProduct = extCProductService.get(id);
        model.addAttribute("obj",extCProduct);

        //准备生产厂家列表
        List<Factory> factoryList = factoryService.getFactoryList();
        model.addAttribute("factoryList",factoryList);
        //准备分类下拉列表

        return "/cargo/contract/jExtCProductUpdate.jsp";
    }

    @RequestMapping("update.action")
    public String update(ExtCProduct extCProduct,Model model){
        extCProductService.update(extCProduct);
        model.addAttribute("contractProductId",extCProduct.getContractProductId());

        return "redirect:/cargo/extcproduct/tocreate.action";
    }

    @RequestMapping("deleteById.action")
    public String deleteById(String id,String contractProductId,Model model ){
        extCProductService.deleteById(id);
        model.addAttribute("contractProductId",contractProductId);

        return "redirect:/cargo/extcproduct/tocreate.action";
    }
}
