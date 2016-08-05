package designpattern.abstractfactory.factory;

import designpattern.abstractfactory.product.Button;
import designpattern.abstractfactory.product.SpringButton;
import designpattern.abstractfactory.product.SpringTextField;
import designpattern.abstractfactory.product.TextField;

/**
 * Created by tangxm on 2016/8/5.
 */
public class SpringSkinFactory implements SkinFactory {
  @Override
  public Button createButton() {
    return new SpringButton();
  }

  @Override
  public TextField createTextField() {
    return new SpringTextField();
  }
}
