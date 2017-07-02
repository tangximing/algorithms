package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxm on 2016/8/23.
 */
public class UnDirectedGraph<T> extends Graph<T> {
  @Override
  public void addEdge(T from, T to) {
    if (!vertices.contains(from))
      vertices.add(from);
    if (!vertices.contains(to))
      vertices.add(to);
    int f = this.vertices.indexOf(from);
    int t = this.vertices.indexOf(to);

    List<Integer> list = edges.get(f);
    if(list == null) list = new ArrayList<>();
    list.add(t);
    edges.put(f, list);

    List<Integer> list1 = edges.get(t);
    if (list1 == null) list1 = new ArrayList<>();
    list1.add(f);
    edges.put(t, list1);
  }
}
