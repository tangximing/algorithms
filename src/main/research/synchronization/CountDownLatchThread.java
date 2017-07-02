package research.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tangxm on 2016/8/15.
 * 概念：一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 * 场景：体育课时老师拿着秒表测试同学的800米成绩，那需求就是很简单了，老师在起跑处组织大家一起跑的瞬间按下秒表计时开始，
 *      然后再终点处等待最后一个学生通过终点后开始汇集学生成绩。
 *
 *    CountDownLatch	                    CyclicBarrier
 * 1.   减计数方式	                          加计数方式
 * 2. 计算为0时释放所有等待的线程	        计数达到指定值时释放所有等待线程
 * 3. 计数为0时，无法重置	               计数达到指定值时，计数置为0重新开始
 * 4. 调用countDown()方法计数减一，
 *    调用await()方法只进行阻塞，对计数没任何影响	调用await()方法计数加1，若加1后的值不等于构造方法的值，则线程阻塞
 * 5. 不可重复利用	                          可重复利用
 */
public class CountDownLatchThread extends Thread {
  private int id;
  private CountDownLatch studentSignal;
  private CountDownLatch teacherSignal;
  public CountDownLatchThread(int id, CountDownLatch studentSignal,
                 CountDownLatch teacherSignal) {
    this.id = id;
    this.studentSignal = studentSignal;
    this.teacherSignal = teacherSignal;
  }
  @Override
  public void run() {
    try {
      teacherSignal.await();
      System.out.println("学生" + id + "起跑...");
      System.out.println("学生" + id + "到达终点。");
      studentSignal.countDown();
      System.out.println("学生" + id + "继续干其他事情");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    CountDownLatch studentSignal = new CountDownLatch(10);
    CountDownLatch teacherSignal = new CountDownLatch(1);
    for (int i = 0; i < 10; i++) {
      executor.execute(new CountDownLatchThread(i, studentSignal, teacherSignal));
    }
    try {
      System.out.println("各就各位！开跑！");
      teacherSignal.countDown();
      studentSignal.await();
      System.out.println("结果发送到汇报成绩的系统");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }
  }
}
