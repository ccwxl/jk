package cn.itcast.jk.controller.cargo.contract;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.FactoryService;

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

		List<ContractProduct> ontractProductlist = contractProductService.find(null);
		model.addAttribute("dataList", ontractProductlist);

		return "/cargo/contract/jContractProductCreate.jsp";
	}

	@RequestMapping("insert.action")
	public String insert(ContractProduct contractProduct, Model model) {
		contractProductService.insert(contractProduct);

		model.addAttribute("contractId", contractProduct.getContractId());// 传递主表id
		return "redirect:/cargo/contractproduct/tocreate.action";
	}

	@RequestMapping("deleteById.action")
	public String deleteByID(String id,String contractId){

		return "redirect:/cargo/contractproduct/tocreate.action";
	}

}
