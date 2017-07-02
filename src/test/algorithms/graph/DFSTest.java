package algorithms.graph;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tangxm on 2016/8/22.
 */
public class DFSTest {
  private Graph<String> graph;

  @Before
  public void init() {
    graph = new UnDirectedGraph<>();
    graph.addEdge("r", "v");
    graph.addEdge("r", "s");
    graph.addEdge("s", "w");
    graph.addEdge("w", "x");
    graph.addEdge("w", "t");
    graph.addEdge("t", "x");
    graph.addEdge("t", "u");
    graph.addEdge("x", "u");
    graph.addEdge("x", "y");
    graph.addEdge("u", "y");
  }

  @Test
  public void test() {
    DFS<String> dfs = new DFS<>(graph, 2);
    dfs.dfs();
    dfs.printPath();
  }
}