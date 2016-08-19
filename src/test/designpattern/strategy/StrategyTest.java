package designpattern.strategy;

import org.junit.Test;

/**
 * Created by tangxm on 2016/8/19.
 */
public class StrategyTest {
  @Test
  public void test() {
    MovieTicket ticket = new MovieTicket();
    ticket.setPrice(30);
    ticket.setDiscount(new StudentDiscount());
    System.out.println(ticket.getPrice());
  }
}