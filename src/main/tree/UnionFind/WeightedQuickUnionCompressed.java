package tree.UnionFind;

/**
 * Created by tangxm on 2016/9/20.
 */
public class WeightedQuickUnionCompressed<T> extends WeightedQuickUnion<T> {

  public WeightedQuickUnionCompressed(int n) {
    super(n);
  }

  @Override
  protected int find(int element) {
    while (element != id[element]) {
      id[element] = id[id[element]]; // 1. 加快到达根节点 2. 尽量多得修改沿途地节点
      element = id[element];
    }

    return element;
  }
}
