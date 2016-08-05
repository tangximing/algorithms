package designpattern.abstractfactory.factory;

import org.junit.Test;

import designpattern.abstractfactory.product.Button;
import designpattern.abstractfactory.product.TextField;

/**
 * Created by tangxm on 2016/8/5.
 */
public class SkinFactoryTest {
  @Test
  public void test() {
    SkinFactory factory = new SpringSkinFactory();
    Button bt = factory.createButton();
    TextField tf = factory.createTextField();
    bt.display();
    tf.display();
  }

}