package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxm on 2016/8/23.
 */
public class DirectedGraph<T> extends Graph<T> {
  @Override
  public void addEdge(T from, T to) {
    if (!vertices.contains(from))
      vertices.add(from);
    if (!vertices.contains(to))
      vertices.add(to);
    int f = this.vertices.indexOf(from);
    int t = this.vertices.indexOf(to);

    List<Integer> list = edges.get(f);
    if(list == null)
      list = new ArrayList<>();
    list.add(t);
    edges.put(f, list);
  }
}
