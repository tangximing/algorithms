package javaresearch.innerClass;

/**
 * Created by tangxm on 2016/8/17.
 */

/**
 * 外部类只能使用public或者default，内部类可以用public/private/protected/default/final/abstract/static修饰
 */
public class Outer {
  public int i;
  private int j;
  public static int k;

  /**
   * 1. 成员内部类需要先生成外部对象后才能访问
   * 2. 成员内部类能访问外部类的所有成员
   * 3. 成员内部类不能拥有静态成员
   */
  private class MemberInner {
    // public static int a = 0;
    public void test() {
      System.out.println(i + ":" + j + ":" + k);
    }
  }

  public void test() {
    MemberInner inner = new MemberInner();
    inner.test();
  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    outer.test();
  }
}
