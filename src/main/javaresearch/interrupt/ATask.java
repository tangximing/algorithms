package javaresearch.interrupt;

/**
 * Created by tangxm on 2016/8/30.
 */
public class ATask implements Runnable {
  private double d = 0.0;

  @Override
  public void run() {
    //死循环执行打印"I am running!" 和做消耗时间的浮点计算
    while (true) {
      System.out.println("I am running!");

      for (int i = 0; i < 900000; i++) {
        d =  d + (Math.PI + Math.E) / d;
      }
      //给线程调度器可以切换到其它进程的信号
      Thread.yield();
    }

  }

  /**
   * 调用interrupt()后，程序仍在运行，如果不强制结束，程序将一直运行下去
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    //将任务交给一个线程执行
    Thread t = new Thread(new ATask());
    t.start();

    //运行一断时间中断线程
    Thread.sleep(10);
    System.out.println("****************************");
    System.out.println("Interrupted Thread!");
    System.out.println("****************************");
    t.interrupt();

  }
}
