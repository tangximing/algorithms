package algorithms.tree.Binary;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/9/20.
 */
public class BinarySearchTreeTest {
  private BinarySearchTree bst;
  private List<Integer> elements;

  @Before
  public void init() {
    bst = new BinarySearchTree();
    elements = Arrays.asList(12, 8, 7, 16, 14, 15);
    bst.addAll(elements);
  }

  @Test
  public void findMinDistance() throws Exception {
    System.out.println(bst.findMinDistance(15));
  }
}