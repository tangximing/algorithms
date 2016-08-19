package designpattern.strategy;

/**
 * Created by tangxm on 2016/8/19.
 */
public class MovieTicket {
  private double price;
  private Discount discount;

  public void setPrice(double price) {
    this.price = price;
  }

  public void setDiscount(Discount discount) {
    this.discount = discount;
  }

  public double getPrice() {
    return discount.calculate(this.price);
  }
}
