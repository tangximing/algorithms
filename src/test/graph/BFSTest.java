package graph;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/8/19.
 */
public class BFSTest extends GraphTest {
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