package designpattern.abstractfactory.factory;

import designpattern.abstractfactory.product.Button;
import designpattern.abstractfactory.product.SummerButton;
import designpattern.abstractfactory.product.SummerTextField;
import designpattern.abstractfactory.product.TextField;

/**
 * Created by tangxm on 2016/8/5.
 */
public class SummerSkinFactory implements SkinFactory {
  @Override
  public Button createButton() {
    return new SummerButton();
  }

  @Override
  public TextField createTextField() {
    return new SummerTextField();
  }
}
