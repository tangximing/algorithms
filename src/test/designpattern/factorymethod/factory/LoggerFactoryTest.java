package designpattern.factorymethod.factory;

import org.junit.Test;

import designpattern.factorymethod.product.Logger;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/8/4.
 */
public class LoggerFactoryTest {
  @Test
  public void createLogger() throws Exception {
    LoggerFactory factory = new DatabaseLoggerFactory();
    Logger logger = factory.createLogger();
    logger.writeLog();
  }

}