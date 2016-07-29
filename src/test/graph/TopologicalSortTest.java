package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/7/29.
 */
public class TopologicalSortTest {
  private Graph<String> graph;
  private TopologicalSort<String> topologicalSort;
  @Before
  public void init() {
    graph = new Graph<>();
    graph.addEdge("a", "c");
    graph.addEdge("b", "c");
    graph.addEdge("a", "d");
    graph.addEdge("c", "e");
    graph.addEdge("c", "f");
    graph.addEdge("d", "e");
    topologicalSort = new TopologicalSort<>();
  }
  @Test
  public void sort() throws Exception {
    List<String> results = topologicalSort.sort(graph);
    for (String str: results) {
      System.out.println(str);
    }
  }

}