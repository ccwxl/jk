package jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DELL on 2016/1/21.
 */
public class BarTest {

    public static void main(String[] args) throws IOException {
        String title="XXX数据统计";
        String categoryAxisLabel="季度";//横列
        String valueAxisLabel="销量(单位:万台)";//纵列
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        dataset.addValue(2000, "IBM", "一季度");
        dataset.addValue(2300, "ORACLE", "一季度");
        dataset.addValue(2800, "JBOSS", "一季度");
        dataset.addValue(3300, "用友", "一季度");

        dataset.addValue(2100, "IBM", "四季度");
        dataset.addValue(2400, "ORACLE", "四季度");
        dataset.addValue(2500, "JBOSS", "四季度");
        dataset.addValue(3200, "用友", "四季度");

        dataset.addValue(4800, "IBM", "二季度");
        dataset.addValue(4300, "ORACLE", "二季度");
        dataset.addValue(3200, "JBOSS", "二季度");
        dataset.addValue(1800, "用友", "二季度");

        dataset.addValue(1500, "IBM", "三季度");
        dataset.addValue(2600, "ORACLE", "三季度");
        dataset.addValue(3900, "JBOSS", "三季度");
        dataset.addValue(2100, "用友", "三季度");


        JFreeChart barChart =  ChartFactory.createBarChart(title,categoryAxisLabel,valueAxisLabel,dataset,PlotOrientation.VERTICAL,true,false,false);

        //设置标题字体的样式
        barChart.getTitle().setFont(new Font("宋体",Font.BOLD,18));

        //简介上的字体
        barChart.getLegend().setItemFont(new Font("宋体",Font.BOLD,18));

        //各个轴上的字体
        CategoryPlot categoryPlot = (CategoryPlot) barChart.getPlot();
        //领轴上的字体
        categoryPlot.getDomainAxis().setLabelFont(new Font("宋体",Font.BOLD,18));
        //横轴的字体
        categoryPlot.getDomainAxis().setTickLabelFont(new Font("宋体",Font.BOLD,18));
       //纵轴的字体
        categoryPlot.getRangeAxis().setLabelFont(new Font("宋体",Font.BOLD,18));
        ChartUtilities.saveChartAsPNG(new File("G:\\barTest.png"),barChart,400,500);
    }
}
