package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by tangxm on 2016/8/19.
 * 树的层序遍历、网络爬虫、寻找最短路径等
 */
public class BFS<T> {
  /**
   * 从起始点到其他点的距离
   * @param graph 图
   * @param start 起始点
   * @return 起始点到其他点的距离
   */
  public Map<Integer, Integer> bfs(Graph<T> graph, int start) {
    Map<Integer, Integer> dist = new HashMap<>();
    Map<Integer, List<Integer>> edges = graph.getEdges();
    dist.put(start, 0);

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    while (!queue.isEmpty()) {
      int front = queue.poll();
      int distance = dist.get(front) + 1;
      List<Integer> neighbors = edges.get(front);
      if (neighbors != null && !neighbors.isEmpty()) {
        neighbors.stream().filter(integer -> !dist.containsKey(integer))
                .forEach(integer -> {
                  dist.put(integer, distance);
                  queue.add(integer);
                });
      }
    }

    return dist;
  }
}
