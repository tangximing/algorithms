package research.iterationRemove;

import java.util.ArrayList;

/**
 * Created by tangxm on 2016/8/17.
 */
public class indexRemove {
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
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals("5"))
        list.remove(i); // 删除的时候会将i后面的所有元素前移一位，这样i++的时候会少遍历一个元素
    }
    for (String str: list)
      System.out.println(str);
  }
}
