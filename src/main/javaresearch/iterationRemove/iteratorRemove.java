package javaresearch.iterationRemove;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by tangxm on 2016/8/17.
 */
public class iteratorRemove {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");
    list.add("7");
    list.add("8");
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      String str = iterator.next();
      if (str.equals("5")) {
        iterator.remove();  //保证了modCount和 expectedModCount 同步
      }
    }
    for (String str: list)
      System.out.println(str);
  }
}
