package algorithms.tree.UnionFind;

/**
 * Created by tangxm on 2016/9/20.
 * 优点：查找快
 * 缺点：合并慢，合并m个点对的时间复杂度是m*n
 */
public class QuickFind<T> extends AbstractUnionFind<T> {

  public QuickFind(int n) {
    super(n);
  }

  @Override
  protected int find(int element) {
    return id[element]; // 查找快
  }

  @Override
  public void union(int first, int second) {
    int pRoot = find(first);
    int qRoot = find(second);
    if (pRoot == qRoot) {
      return;
    }

    // 每次修改要遍历所有的点，将组号为pRoot的点的组号改为qRoot，效率不高
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pRoot) {
        id[i] = qRoot;
      }
    }
  }
}
