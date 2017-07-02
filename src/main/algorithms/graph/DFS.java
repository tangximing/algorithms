package algorithms.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by tangxm on 2016/8/22.
 * 树的前中后序遍历、连通性问题、寻找从顶点v到顶点w的路径等
 */
public class DFS<T> {
  private Map<Integer, List<Integer>> edges;
  private List<T> vertices;
  private Integer[] path;
  private int start;
  private Set<Integer> visited;

  public DFS(Graph<T> graph, int start) {
    this.start = start;
    this.edges = graph.getEdges();
    this.path = new Integer[graph.getVertex()];
    this.visited = new HashSet<>(graph.getVertex());
    this.vertices = graph.getVertices();
  }

  /**
   * dfs
   */
  public void dfs() {
    dfs(start);
  }
  private void dfs(int start) {
    visited.add(start);
    List<Integer> neighbors = edges.get(start);
    if (neighbors != null) {
      neighbors.stream().filter(neighbor -> !visited.contains(neighbor)).forEach(neighbor -> {
        visited.add(neighbor);
        path[neighbor] = start;
        dfs(neighbor);
      });
    }
  }

  /**
   * print all paths
   */
  public void printPath() {
    for (int i = 0; i < path.length; i++) {
      if (i != start)
        pathTo(i);
    }
  }
  private void pathTo(int dest) {
    Stack<Integer> stack = new Stack<>();
    for (int x = dest; x != start; x = path[x])
      stack.push(x);
    stack.push(start);
    while (!stack.isEmpty()) {
      System.out.print(vertices.get(stack.pop()) + " ");
    }
    System.out.println();
  }
}
