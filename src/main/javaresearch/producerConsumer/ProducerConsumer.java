package javaresearch.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by tangxm on 2016/8/24.
 */
public class ProducerConsumer {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    int maxSize = 10;
    ProducerThread producerThread = new ProducerThread(queue, maxSize);
    ConsumerThread consumerThread = new ConsumerThread(queue, maxSize);
    producerThread.start();
    consumerThread.start();
  }

  /**
   * 生产者线程
   */
  private static class ProducerThread extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public ProducerThread(Queue<Integer> queue, int maxSize) {
      this.queue = queue;
      this.maxSize = maxSize;
    }

    @Override
    public void run() {
      while (true) {
        /**
         * 同步块要获取多个线程共享对象的锁
         */
        synchronized (this.queue) {
          /**
           * 需要用while进行条件判断，避免虚假唤醒
           * 虚假唤醒在linux的多处理器系统中/在程序接收到信号时可能回发生。
           * notify唤醒随机一个，notifyAll会唤醒所有对应的wait的线程，但是并非所有都是需要唤醒的，
           * 这个就是所谓的虚假唤醒了
           */
          while (this.queue.size() == maxSize) {
            try {
              System.out.println("Queue is full, waiting for consuming...");
              this.queue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

          int tmp = new Random().nextInt();
          System.out.println("Producing: " + tmp);
          this.queue.offer(tmp);
          this.queue.notifyAll();
        }
      }
    }
  }

  /**
   * 消费者线程
   */
  private static class ConsumerThread extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public ConsumerThread(Queue<Integer> queue, int maxSize) {
      this.queue = queue;
      this.maxSize = maxSize;
    }

    @Override
    public void run() {
      while (true) {
        synchronized (this.queue) {
          while (this.queue.isEmpty()) {
            try {
              System.out.println("Queue is empty, waiting for producing...");
              this.queue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

          System.out.println("Consuming: " + this.queue.poll());
          this.queue.notifyAll();
        }
      }
    }
  }
}
