package designpattern.strategy;

/**
 * Created by tangxm on 2016/8/19.
 * 策略模式：为了达到一个目标，有很多不同的算法，每个算法就是一种策略，也就是一个类。
 * 抽象策略: Discount 具体策略: StudentDiscount
 * 策略环境：MovieTicket
 */
interface Discount {
  double calculate(double price);
}
