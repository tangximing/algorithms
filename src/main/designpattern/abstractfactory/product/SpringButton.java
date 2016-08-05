package designpattern.abstractfactory.product;

/**
 * Created by tangxm on 2016/8/5.
 */
public class SpringButton implements Button {
  @Override
  public void display() {
    System.out.println("显示浅绿色按钮");
  }
}
