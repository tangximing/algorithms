package algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by tangxm on 2016/8/19.
 */
public class BFSTest {
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
  public void bfs() {
    BFS<String> bfs = new BFS<>();
    Map<Integer, Integer> dist = bfs.bfs(graph, 0);
    List<String> vertices = graph.getVertices();
    String start = vertices.get(0);
    for (Map.Entry<Integer, Integer> entry: dist.entrySet()) {
      System.out.println(start + " -> " + vertices.get(entry.getKey()) + ":" + entry.getValue());
    }
  }

}