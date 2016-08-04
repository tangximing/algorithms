package designpattern.simplefactory;

import designpattern.simplefactory.product.Chart;
import designpattern.simplefactory.product.HistogramChart;
import designpattern.simplefactory.product.LineChart;
import designpattern.simplefactory.product.PieChart;

/**
 * Created by tangxm on 2016/8/1.
 * 概念：定义一个抽象产品类或接口，多个具体产品类，一个简单工厂类。
 *      简单工厂类根据客户端传入的参数创造具体产品。
 * 缺点：工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都会受到影响；
 *      系统扩展困难，增加一个产品，就需要修改工厂逻辑
 */
public class ChartFactory {
  public static Chart getChart(String type) {
    Chart chart = null;
    switch (type) {
      case "histogram":
        chart = new HistogramChart();
        break;
      case "pie":
        chart = new PieChart();
        break;
      case "line":
        chart = new LineChart();
        break;
    }

    return chart;
  }
}
