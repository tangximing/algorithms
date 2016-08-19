package graph;

import org.junit.Before;

/**
 * Created by tangxm on 2016/8/19.
 * r —— s    t —— u
 * |    | /  |  / |
 * v    w —— x —— y
 */
public class GraphTest {
  protected Graph<String> graph;
  @Before
  public void init() {
    graph = new Graph<>();
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
}