package designpattern.strategy;

/**
 * Created by tangxm on 2016/8/19.
 */
public class StudentDiscount implements Discount {
  @Override
  public double calculate(double price) {
    System.out.println("学生票：");
    return price * 0.8;
  }
}
