package cn.wxl.jk.controller.cargo.contract;



import java.util.List;

import javax.annotation.Resource;

import cn.wxl.jk.controller.BaseController;
import cn.wxl.jk.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wxl.jk.domain.Contract;

@Controller
@RequestMapping("/cargo/contract/")
public class ContractController extends BaseController {

	@Resource(name = "contractService")
	private ContractService contractService;

	// 列表
	@RequestMapping("list.action")
	public String list(Model model) {
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList", dataList);
		return "/cargo/contract/jContractList.jsp";// 带着jsp方便以后传递参数
	}

	// 新增页面
	@RequestMapping("tocreate.action")
	public String tocreate() {

		return "/cargo/contract/jContractCreate.jsp";
	}

	// 新增
	@RequestMapping("insert.action")
	public String insert(Contract contract) {
		contractService.insert(contract);
		return "redirect:/cargo/contract/list.action";
	}

	// 修改,数据回显
	@RequestMapping("toupdate.action")
	public String toupdate(String id, Model model) {
		Contract contract = contractService.get(id);
		model.addAttribute("obj", contract);
		return "/cargo/contract/jContractUpdate.jsp";
	}

	// 保存修改
	@RequestMapping("update.action")
	public String update(Contract  contract) {
		contractService.update(contract);
		return "redirect:/cargo/contract/list.action";
	}

	// 删除一条
	@RequestMapping("deleteById.action")
	public String deleteById(String id) {
		contractService.deleteById(id);
		return "redirect:/cargo/contract/list.action";
	}

	// 删除多条
	@RequestMapping("delete.action")
	public String delete(@RequestParam("id") String[] ids) {
		contractService.delete(ids);
		return "redirect:/cargo/contract/list.action";
	}

	// 查看
	@RequestMapping("toview.action")
	public String toview(String id,Model model) {
		Contract contract = contractService.get(id);
		model.addAttribute("obj", contract);
		return "/cargo/contract/jContractView.jsp";
	}

	// 启用一条或多条
	@RequestMapping("submit.action")
	public String submit(@RequestParam("id") String[] ids) {
		contractService.updateStart(ids);
		return "redirect:/cargo/contract/list.action";
	}

	// 禁用一条或多条
	@RequestMapping("cancel.action")
	public String cancel(@RequestParam("id") String[] ids) {
		contractService.updateStop(ids);
		return "redirect:/cargo/contract/list.action";
	}
}
