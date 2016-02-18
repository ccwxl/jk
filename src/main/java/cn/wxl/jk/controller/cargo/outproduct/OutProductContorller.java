package cn.wxl.jk.controller.cargo.outproduct;

import cn.wxl.jk.VO.OutProductVO;
import cn.wxl.jk.controller.BaseController;
import cn.wxl.jk.dao.OutProductDao;
import cn.wxl.jk.service.OutProductService;
import cn.wxl.util.DownloadUtil;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;

/**
 * Created by DELL on 2016/1/31.
 */
@Controller
@RequestMapping("/cargo/outproduct/")
public class OutProductContorller extends BaseController {

	@Resource
	@Qualifier(value = "outProductService")
	private OutProductService outProductService;

	@RequestMapping("toedit.action")
	public String toedit() {

		return "/cargo/outproduct/jOutProduct.jsp";
	}

	@RequestMapping("print.action")
	public void printNotTemplate(String inputDate,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获取模板文件的路径
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "make/xlsprint/";
		// 获取输入流
		InputStream inputStream = new FileInputStream(new File(path
				+ "tOUTPRODUCT.xls"));
		// 读入excle
		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
		// 获取第一个sheet
		Sheet sheet = wb.getSheetAt(0);
		
		Row row; // 定义行
		Cell cell; // 定义列
		int rowNo = 0; // 定义行号
		int colNo = 1; // 定义列号
		
		row = sheet.getRow(2);//获取到行,准备格式
		//获取客户的样式
		cell = row.getCell(1);
		CellStyle customStyle  = cell.getCellStyle();
		//获取订单号的样式
		cell = row.getCell(2);
		CellStyle contractNoStyle  = cell.getCellStyle();
		//货号
		cell = row.getCell(3);
		CellStyle productNoStyle  = cell.getCellStyle();
		//数量
		cell = row.getCell(4);
		CellStyle numStyle = cell.getCellStyle();	
		//生产厂家的样式
		cell = row.getCell(5);
		CellStyle factoryStyle = cell.getCellStyle();		
		//日期的样式
		cell = row.getCell(6);
		CellStyle dateStyle = cell.getCellStyle();		
		//贸易条款的样式
		cell = row.getCell(8);
		CellStyle tradeStyle = cell.getCellStyle();		
		
		//处理大标题
		row = sheet.getRow(rowNo++);//获取第一行
		cell=row.getCell(colNo);
		cell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表");
		//跳过二级标题
		rowNo++;	
		//处理内容
		List<OutProductVO> outProductVOList = outProductService.find(inputDate);
		for (int j = 0; j < outProductVOList.size(); j++) {
			//获取当前数据
			OutProductVO outProductVO = outProductVOList.get(j);
			
			colNo = 1;  //列初始化
			
			row = sheet.createRow(rowNo++);
			row.setHeightInPoints(24);// 设置行高

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getCustomName());
			cell.setCellStyle(customStyle);

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getContractNo());
			cell.setCellStyle(contractNoStyle);

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getProductNo());
			cell.setCellStyle(productNoStyle);

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getCnumber());
			cell.setCellStyle(numStyle);

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getFactoryName());
			cell.setCellStyle(factoryStyle);

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getDeliveryPeriod());
			cell.setCellStyle(dateStyle);

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getShipTime());
			cell.setCellStyle(dateStyle);

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getTradeTerms());
			cell.setCellStyle(tradeStyle);
		}
		
		ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
		//工作表写入到ByteArrayOutputStream
		wb.write(byteArrayOutputStream);
		//下载
		DownloadUtil downloadUtil =new DownloadUtil();
		downloadUtil.download(byteArrayOutputStream, response, "出货表.xls");
	}

	@RequestMapping("print1.action")
	public void printNotemplate(String inputDate, HttpServletResponse response)
			throws IOException {
		List<OutProductVO> outProductVOList = outProductService.find(inputDate);
		// 创建一个工作表
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row; // 定义行
		HSSFCell cell; // 定义列
		int rowNo = 0; // 定义行号
		int colNo = 1; // 定义列号
		// 设置样式
		HSSFCellStyle cellStyle;
		HSSFFont hssfFont;
		// 列宽
		sheet.setColumnWidth(0, 1);
		sheet.setColumnWidth(1, 26 * 256);
		sheet.setColumnWidth(2, 11 * 256);
		sheet.setColumnWidth(3, 29 * 256);
		sheet.setColumnWidth(4, 11 * 256);
		sheet.setColumnWidth(5, 15 * 256);
		sheet.setColumnWidth(6, 10 * 256);
		sheet.setColumnWidth(7, 10 * 256);
		sheet.setColumnWidth(8, 9 * 256);
		// 大标题
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 9)); // 合并
		row = sheet.createRow(rowNo++);
		row.setHeightInPoints(36); // 行高
		cell = row.createCell(1);
		cellStyle = wb.createCellStyle();
		hssfFont = wb.createFont();
		cell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-",
				"年")
				+ "月份出货表"); // yyyy-MM
		cell.setCellStyle(this.bigTitle(wb, cellStyle, hssfFont));

		// 定义小标题 客户 订单号 货号 数量 工厂 工厂交期 船期 贸易条款
		String[] title = new String[] { "客户", "订单号", "货号", "数量", "工厂", "工厂交期",
				"船期", "贸易条款" };
		row = sheet.createRow(rowNo++); // 写一行
		row.setHeightInPoints(26);
		cellStyle = wb.createCellStyle();
		hssfFont = wb.createFont();
		// 写title
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i + 1);
			cell.setCellValue(title[i]);
			cell.setCellStyle(this.smartTitle(wb, cellStyle, hssfFont));
		}

		// 文本样式
		cellStyle = wb.createCellStyle();
		hssfFont = wb.createFont();
		for (int j = 0; j < outProductVOList.size(); j++) {
			OutProductVO outProductVO = outProductVOList.get(j);
			colNo = 1;
			row = sheet.createRow(rowNo++);
			row.setHeightInPoints(24);// 设置行高

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getCustomName());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getContractNo());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getProductNo());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getCnumber());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getFactoryName());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getDeliveryPeriod());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getShipTime());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

			cell = row.createCell(colNo++);
			cell.setCellValue(outProductVO.getTradeTerms());
			cell.setCellStyle(this.textCellStyle(wb, cellStyle, hssfFont));

		}
		// 写入文件

		// OutputStream os=new FileOutputStream("D://productExp.xls");
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		wb.write(byteArrayOutputStream);
		// os.close();
		DownloadUtil downloadUtil = new DownloadUtil();
		downloadUtil.download(byteArrayOutputStream, response, "出货表.xls");

	}

	// 大标题样式
	public CellStyle bigTitle(HSSFWorkbook wb, CellStyle cellStyle, Font font) {
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 16);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 字体加粗

		cellStyle.setFont(font);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER); // 横向的格式
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向格式

		return cellStyle;
	}

	// 标题样式
	public CellStyle smartTitle(HSSFWorkbook wb, CellStyle cellStyle, Font font) {
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 字体加粗

		cellStyle.setFont(font);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER); // 横向的格式
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向格式

		cellStyle.setBorderTop(CellStyle.BORDER_THIN); // 设置四周边线，细线
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);

		return cellStyle;
	}

	// 文本格式
	public CellStyle textCellStyle(HSSFWorkbook wb, CellStyle cellStyle,
			Font font) {
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 10);
		cellStyle.setFont(font);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT); // 横向的格式
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向格式

		cellStyle.setBorderTop(CellStyle.BORDER_THIN);// 表格线
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);// 表格线
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);// 表格线
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);// 表格线

		return cellStyle;
	}
}
