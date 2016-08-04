package designpattern.simplefactory;

import org.junit.Test;

import designpattern.simplefactory.product.Chart;

/**
 * Created by tangxm on 2016/8/1.
 */
public class ChartFactoryTest {
  @Test
  public void getChart() throws Exception {
    Chart chart = ChartFactory.getChart("line");
    chart.display();
  }

}