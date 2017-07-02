package algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangxm on 2016/7/29.
 * 图
 */
public abstract class Graph<T> {
  protected Map<Integer, List<Integer>> edges; // 图的边
  protected List<T> vertices; // 图的顶点

  public Graph() {
    this.vertices = new ArrayList<>();
    this.edges = new HashMap<>();

  }
  public abstract void addEdge(T from, T to);

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
