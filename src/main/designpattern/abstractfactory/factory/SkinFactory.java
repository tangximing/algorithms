package designpattern.abstractfactory.factory;

import designpattern.abstractfactory.product.Button;
import designpattern.abstractfactory.product.TextField;

/**
 * Created by tangxm on 2016/8/5.
 * 工厂方法模式中一个工厂对应只能生成一种产品，抽象工厂模式中一个工厂可以生成一簇产品
 */
public interface SkinFactory {
  Button createButton();
  TextField createTextField();
}
