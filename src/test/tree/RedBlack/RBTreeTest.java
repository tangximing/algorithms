package tree.RedBlack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tangxm on 2016/8/10.
 */
public class RBTreeTest {
  @Test
  public void testInsert(){
    List<Integer> list = Arrays.asList(
            12, 1, 9, 2, 0, 11, 7, 19, 4, 15, 18, 5, 14, 13, 10, 16, 6, 3, 8, 17);
    RBTree tree = new RBTree();
    tree.insert(list);
    tree.preOrder();
    System.out.println();
    tree.inOrder();
  }

  @Test
  public void testRemove() {
    List<Integer> list = Arrays.asList(
            12, 1, 9, 2, 0, 11, 7, 19, 4, 15, 18, 5, 14, 13, 10, 16, 6, 3, 8, 17);
    RBTree tree = new RBTree();
    tree.insert(list);
    tree.remove(12);
  }
}