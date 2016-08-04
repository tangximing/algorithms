package designpattern.factorymethod.product;

/**
 * Created by tangxm on 2016/8/4.
 */
public class FileLogger implements Logger {
  @Override
  public void writeLog() {
    System.out.println("file logger");
  }
}
