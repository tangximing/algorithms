package algorithms.list;

/**
 * Created by tangxm on 2016/8/25.
 * 1. 判断单链表是否有环以及环的入口点
 */
public class ListQA<T> {

  /**
   * 链表头节点
   */
  private LinkedNode head;
  /**
   * 单链表中的节点
   */
  private class LinkedNode {
    T data;
    LinkedNode next;

    public LinkedNode(T data) {
      this.data = data;
      this.next = null;
    }
  }

  public void headBuild(T[] arrays) {
    if (arrays == null || arrays.length == 0)
      return;
    LinkedNode r = head;
    for (T item: arrays) {
      LinkedNode node = new LinkedNode(item);
      if (head == null) {
        head = node;
        r = head;
        continue;
      }
      r.next = node;
      r = node;
    }
  }

  public void print() {
    LinkedNode node = head;
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  /**
   * 1. 判断单链表是否有环以及环的入口点
   */
  public void getLoopNode() {
    LinkedNode loopNode = getLoopNode(head);
    if (loopNode != null) {
      System.out.println(loopNode.data);
    } else {
      System.out.println("无环");
    }
  }
  private LinkedNode getLoopNode(LinkedNode head) {
    if (head == null) return null;
    LinkedNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // 说明有环
      if (slow == fast)
        break;
    }

    if (fast == null || fast.next == null)
      return null;

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}
