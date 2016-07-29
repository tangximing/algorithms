package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangxm on 2016/7/29.
 * 图
 */
public class Graph<T> {
  private Map<Integer, List<Integer>> edges; // 图的边
  private List<T> vertices; // 图的顶点

  public Graph() {
    this.vertices = new ArrayList<>();
    this.edges = new HashMap<>();

  }
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

  public int getVertex() {
    return this.vertices.size();
  }

  public Map<Integer, List<Integer>> getEdges() {
    return this.edges;
  }

  public List<T> getVertices() {
    return vertices;
  }
}
