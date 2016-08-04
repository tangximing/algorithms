package designpattern.factorymethod.factory;

import designpattern.factorymethod.product.Logger;

/**
 * Created by tangxm on 2016/8/4.
 * 概念：在简单工厂的基础上，增加抽象工厂类，每个具体产品对应一个具体工厂，又具体工厂创建具体产品
 */
public interface LoggerFactory {
  Logger createLogger();
}
