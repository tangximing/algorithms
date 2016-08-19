package designpattern.strategy;

/**
 * Created by tangxm on 2016/8/19.
 */
public class ChildDiscount implements Discount {
  @Override
  public double calculate(double price) {
    System.out.println("儿童票：");
    return price - 10;
  }
}
