package javaresearch.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tangxm on 2016/8/15.
 * 概念：一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点
 * 场景：有四个游戏玩家玩游戏，游戏有三个关卡，每个关卡必须要所有玩家都到达后才能允许通关。
 */
public class CyclicBarrierThread extends Thread {
  private CyclicBarrier cyclicBarrier;
  private int id;
  public CyclicBarrierThread(int id, CyclicBarrier cyclicBarrier) {
    this.cyclicBarrier = cyclicBarrier;
    this.id = id;
  }
  @Override
  public void run() {
    try {
      System.out.println("玩家" + id + "通过第一关...");
      cyclicBarrier.await();
      System.out.println("玩家" + id + "进入第二关...");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
      @Override
      public void run() {
        System.out.println("所有玩家通过第一关！");
      }
    });
    for (int i = 0; i < 4; i++) {
      executor.execute(new CyclicBarrierThread(i, barrier));
    }
    executor.shutdown();
  }
}
