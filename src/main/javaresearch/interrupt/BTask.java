package javaresearch.interrupt;

/**
 * Created by tangxm on 2016/8/30.
 */
public class BTask implements Runnable {
  private double d = 0.0;

  @Override
  public void run() {
    //死循环执行打印"I am running!" 和做消耗时间的浮点计算
    try {
      while (true) {
        System.out.println("I am running!");

        for (int i = 0; i < 900000; i++) {
          d =  d + (Math.PI + Math.E) / d;
        }
        //给线程调度器可以切换到其它进程的信号
        Thread.sleep(50);
      }
    } catch (InterruptedException e) {
      System.out.println("BTask.run() interrupted!");
    }


  }

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    //将任务交给一个线程执行
    Thread t = new Thread(new BTask());
    t.start();

    //运行一断时间中断线程
    Thread.sleep(100);
    System.out.println("****************************");
    System.out.println("Interrupted Thread!");
    System.out.println("****************************");
    t.interrupt();

  }
}
