package tree.UnionFind;

/**
 * Created by tangxm on 2016/9/20.
 * 优点：每次合并不是简单地将一棵树作为另外一棵树的子树，而是要根据两棵树的规模，将小树作为大树的子树
 */
public class WeightedQuickUnion<T> extends QuickUnion<T> {

  private int[] size;

  public WeightedQuickUnion(int n) {
    super(n);
    size = new int[n];
    for (int i = 0; i < n; i++) {
      size[i] = 1;
    }
  }

  @Override
  public void union(int first, int second) {
    int pRoot = find(first);
    int qRoot = find(second);
    if (pRoot == qRoot) {
      return;
    }

    if (size[pRoot] > size[qRoot]) {
      id[qRoot] = pRoot;
      size[pRoot] += size[qRoot];
    } else {
      id[pRoot] = qRoot;
      size[qRoot] += size[pRoot];
    }

    count--;
  }
}
