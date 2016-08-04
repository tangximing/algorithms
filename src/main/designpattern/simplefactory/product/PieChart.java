package designpattern.simplefactory.product;

/**
 * Created by tangxm on 2016/8/1.
 */
public class PieChart implements Chart {
  public PieChart() {
    System.out.println("创建饼状图");
  }

  @Override
  public void display() {
    System.out.println("显示饼状图");
  }
}
