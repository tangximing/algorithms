package research.interrupt;

/**
 * Created by tangxm on 2016/8/30.
 */
public class CTask implements Runnable {
  private double d = 0.0;

  public void run() {

    //检查程序是否发生中断
    while (!Thread.interrupted()) {
      System.out.println("I am running!");
      System.out.println("Calculating");
      for (int i = 0; i < 900000; i++) {
        d = d + (Math.PI + Math.E) / d;
      }
    }

    System.out.println("CTask.run() interrupted!");
  }

  public static void main(String[] args) throws InterruptedException {
    //将任务交给一个线程执行
    Thread t = new Thread(new CTask());
    t.start();

    //运行一断时间中断线程
    Thread.sleep(100);
    System.out.println("****************************");
    System.out.println("Interrupted Thread!");
    System.out.println("****************************");
    t.interrupt();

  }
}
