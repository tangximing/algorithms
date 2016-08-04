package designpattern.factorymethod.factory;

import designpattern.factorymethod.product.FileLogger;
import designpattern.factorymethod.product.Logger;

/**
 * Created by tangxm on 2016/8/4.
 */
public class FileLoggerFactory implements LoggerFactory {
  @Override
  public Logger createLogger() {
    return new FileLogger();
  }
}
