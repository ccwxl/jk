package cn.itcast.jk.controller.basicinfo.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;

@Controller
@RequestMapping("/basicinfo/factory/")
public class FactoryController extends BaseController {

	@Resource(name = "factoryService")
	private FactoryService factoryService;

	// 列表
	@RequestMapping("list.action")
	public String list(Model model) {
		List<Factory> dataList = factoryService.find(null);
		model.addAttribute("dataList", dataList);
		return "/basicinfo/factory/jFactoryList.jsp";// 带着jsp方便以后传递参数
	}

	// 新增页面
	@RequestMapping("tocreate.action")
	public String tocreate() {

		return "/basicinfo/factory/jFactoryCreate.jsp";
	}

	// 新增
	@RequestMapping("insert.action")
	public String insert(Factory factory) {
		factoryService.insert(factory);
		return "redirect:/basicinfo/factory/list.action";
	}

	// 修改,数据回显
	@RequestMapping("toupdate.action")
	public String toupdate(String id, Model model) {
		Factory factory = factoryService.get(id);
		model.addAttribute("obj", factory);
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}

	// 保存修改
	@RequestMapping("update.action")
	public String update(Factory factory) {
		factoryService.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}

	// 删除一条
	@RequestMapping("deleteById.action")
	public String deleteById(String id) {
		factoryService.deleteById(id);
		return "redirect:/basicinfo/factory/list.action";
	}

	// 删除多条
	@RequestMapping("delete.action")
	public String delete(@RequestParam("id") String[] ids) {
		factoryService.delete(ids);
		return "redirect:/basicinfo/factory/list.action";
	}

	// 查看
	@RequestMapping("toview.action")
	public String toview(String id,Model model) {
		Factory factory = factoryService.get(id);
		model.addAttribute("obj", factory);
		return "/basicinfo/factory/jFactoryView.jsp";
	}

	// 启用一条或多条
	@RequestMapping("start.action")
	public String start(@RequestParam("id") String[] ids) {
		factoryService.updateStart(ids);
		return "redirect:/basicinfo/factory/list.action";
	}

	// 禁用一条或多条
	@RequestMapping("stop.action")
	public String stop(@RequestParam("id") String[] ids) {
		factoryService.updateStop(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
}
