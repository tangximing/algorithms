package algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by tangxm on 2016/7/29.
 */
public class TopologicalSortTest {
  private Graph<String> graph;

  @Before
  public void init() {
    graph = new DirectedGraph<>();
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
  public void sort() throws Exception {
    TopologicalSort<String> topologicalSort = new TopologicalSort<>();
    List<String> results = topologicalSort.sort(graph);
    results.stream().forEach(System.out::println);
  }

}