package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by tangxm on 2016/7/29.
 * 针对有向无环图的拓扑排序
 * ref: http://www.acmerblog.com/topological-sorting-5896.html
 */
public class TopologicalSort<T> {
 public List<T> sort(Graph<T> graph) {
   List<T> vertices = graph.getVertices();
   Map<Integer, List<Integer>> edges = graph.getEdges();

   List<T> results = new ArrayList<>();
   int[] inDegrees = new int[graph.getVertex()]; // 用于存储每个点的入度
   Queue<Integer> queue = new LinkedList<>(); // 用于存储入度为0的点

   /** 遍历邻接表，统计各个顶点的入度*/
   for (Map.Entry<Integer, List<Integer>> edge: edges.entrySet()) {
     for (Integer i: edge.getValue()) {
       inDegrees[i]++;
     }
   }

   /** 将入度为0的顶点加入队列*/
   for (int i = 0; i < inDegrees.length; i++) {
     if (inDegrees[i] == 0)
       queue.offer(i);
   }

   /** 移除入度为0的顶点，并更新各个顶点的入度表，将新的入度为0的点加入队列*/
   while (!queue.isEmpty()) {
     int front = queue.poll();
     results.add(vertices.get(front));
     List<Integer> toList = edges.get(front);
     if (toList != null) {
       for (Integer to: edges.get(front)) {
         inDegrees[to]--;
         if (inDegrees[to] == 0)
           queue.offer(to);
       }
     }
   }
   return results;
 }
}
