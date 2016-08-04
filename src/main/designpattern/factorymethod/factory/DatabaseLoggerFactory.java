package designpattern.factorymethod.factory;

import designpattern.factorymethod.product.DatabaseLogger;
import designpattern.factorymethod.product.Logger;

/**
 * Created by tangxm on 2016/8/4.
 */
public class DatabaseLoggerFactory implements LoggerFactory {
  @Override
  public Logger createLogger() {
    return new DatabaseLogger();
  }
}
