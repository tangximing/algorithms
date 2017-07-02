package research.synchronization;

import java.util.concurrent.Semaphore;

/**
 * Created by tangxm on 2016/8/15.
 * 概念：信号量，用于控制对共享资源的并发访问。
 *      当信号量用完之前，每个线程都可以acquire一个permit，之后release；
 *      当信号量用完之后，其他线程acquire的时候，会block
 */
public class SemaphoreThread extends Thread {
  public Semaphore semaphore;
  public SemaphoreThread(String name, Semaphore semaphore) {
    setName(name);
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    try {
      System.out.println(getName() + "取号等待..." + System.currentTimeMillis());
      semaphore.acquire();
      System.out.println(getName() + "提供服务..." + System.currentTimeMillis());
      sleep(1000);
      System.out.println(getName() + "完成服务..." + System.currentTimeMillis());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("释放..." + System.currentTimeMillis());
    semaphore.release();
  }

  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(3);
    SemaphoreThread testA = new SemaphoreThread("A", semaphore);
    SemaphoreThread testB = new SemaphoreThread("B", semaphore);
    SemaphoreThread testC = new SemaphoreThread("C", semaphore);
    SemaphoreThread testD = new SemaphoreThread("D", semaphore);
    SemaphoreThread testE = new SemaphoreThread("E", semaphore);
    SemaphoreThread testF = new SemaphoreThread("F", semaphore);
    SemaphoreThread testG = new SemaphoreThread("G", semaphore);
    testA.start();
    testB.start();
    testC.start();
    testD.start();
    testE.start();
    testF.start();
    testG.start();
  }
}
