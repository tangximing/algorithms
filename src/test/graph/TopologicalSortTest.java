package graph;

import org.junit.Test;

import java.util.List;

/**
 * Created by tangxm on 2016/7/29.
 */
public class TopologicalSortTest extends GraphTest{
  @Test
  public void sort() throws Exception {
    TopologicalSort<String> topologicalSort = new TopologicalSort<>();
    List<String> results = topologicalSort.sort(graph);
    results.stream().forEach(System.out::println);
  }

}