package research.iterationRemove;

import java.util.ArrayList;

/**
 * Created by tangxm on 2016/8/17.
 */
public class objectRemove {
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
    // Iterator
    // 会修改modCount, 造成Iterator中的expectedModCount和modCount不同步，抛出异常
    list.stream().filter(str -> str.equals("5")).forEach(list::remove);

    list.forEach(System.out::println);
  }
}
