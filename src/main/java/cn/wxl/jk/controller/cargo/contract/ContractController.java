package cn.wxl.jk.controller.cargo.contract;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wxl.jk.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wxl.jk.VO.ContractVO;
import cn.wxl.jk.domain.Contract;
import cn.wxl.jk.print.ContractPrint;
import cn.wxl.jk.print.ContractPrintTemplate;
import cn.wxl.jk.service.ContractService;

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
		ContractVO obj = contractService.view(id);
		model.addAttribute("obj", obj);
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
	
	    //打印
		@RequestMapping("print.action")
		public void print(String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
			ContractPrint cp = new ContractPrint();
			
			ContractVO obj = contractService.view(id);
			cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
		}
		
		//合同模板打印
		@RequestMapping("printTemplate.action")
		public void printTemplate(String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
			ContractPrintTemplate cp = new ContractPrintTemplate();
			
			ContractVO obj = contractService.view(id);
			cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
			//cp.print();
		}
}
