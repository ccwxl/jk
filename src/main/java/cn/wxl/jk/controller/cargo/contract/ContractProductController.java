package cn.wxl.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.wxl.jk.controller.BaseController;
import cn.wxl.jk.domain.ContractProduct;
import cn.wxl.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wxl.jk.domain.Factory;
import cn.wxl.jk.service.ContractProductService;

@Controller
@RequestMapping("/cargo/contractproduct/")
public class ContractProductController extends BaseController {

	@Resource(name = "contractProductService")
	private ContractProductService contractProductService;

	@Resource(name = "factoryService")
	private FactoryService factoryService;

	// 添加货物
	@RequestMapping("tocreate.action")
	public String tocreate(String contractId, Model model) {
		model.addAttribute("contractId", contractId);
		// 查询获取生产厂家的列表

		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);

		// 显示下面的货物列表
		Map paraMap = new HashMap();
		paraMap.put("contractId", contractId);
		List<ContractProduct> ontractProductlist = contractProductService.find(paraMap);
		model.addAttribute("dataList", ontractProductlist);

		return "/cargo/contract/jContractProductCreate.jsp";
	}

	@RequestMapping("insert.action")
	public String insert(ContractProduct contractProduct, Model model) {
		contractProductService.insert(contractProduct);
		model.addAttribute("contractId", contractProduct.getContractId());// 传递主表id
		return "redirect:/cargo/contractproduct/tocreate.action";
	}

	@RequestMapping("toupdate.action")
	public String topdate(String id,Model model){
		ContractProduct obj= contractProductService.get(id);
		model.addAttribute("obj",obj);

		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);

		return  "/cargo/contract/jContractProductUpdate.jsp";
	}

	@RequestMapping("update.action")
	public String update(ContractProduct contractProduct,Model model){
		contractProductService.update(contractProduct);
		model.addAttribute("contractId", contractProduct.getId());
		return "redirect:/cargo/contractproduct/tocreate.action";
	}

	@RequestMapping("deleteById.action")
	public String deleteById(String id,String contractId,Model model){
		contractProductService.deleteById(id);
		model.addAttribute("contractId", contractId);

		return "redirect:/cargo/contractproduct/tocreate.action";
	}

}
