package tree.Binary;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxm on 2016/8/22.
 */
public class BinaryTreeTest {
  private BinaryTree<Integer> bt;

  @Before
  public void init() {
    bt = new BinaryTree<>();
    /**
     *       4
     *     /   \
     *    1     8
     *   / \   / \
     *  2   3 7   9
     *       / \
     *      5  6
     */
    Integer[] pre = {4, 1, 2, 3, 8, 7, 5, 6, 9};
    Integer[] in = {2, 1, 3, 4, 5, 7, 6, 8, 9};
    bt.buildPreIn(pre, in);
  }
  @Test
  public void preOrder_Recursion() throws Exception {
    System.out.println("递归先序遍历：");
    bt.preOrder_Recursion();
  }

  @Test
  public void inOrder_Recursion() throws Exception {
    System.out.println("递归中序遍历：");
    bt.inOrder_Recursion();
  }

  @Test
  public void postOrder_Recursion() throws Exception {
    System.out.println("递归后序遍历：");
    bt.postOrder_Recursion();
  }

  @Test
  public void preOrder_iteration() throws Exception {
    System.out.println("迭代先序遍历：");
    bt.preOrder_iteration();
  }

  @Test
  public void inOrder_iteration() throws Exception {
    System.out.println("迭代中序遍历：");
    bt.inOrder_iteration();
  }

  @Test
  public void postOrder_iteration() throws Exception {
    System.out.println("迭代后序遍历：");
    bt.postOrder_iteration();
  }

  @Test
  public void getNumber_Recursion() throws Exception {
    System.out.println("递归二叉树的节点个数：");
    System.out.println(bt.getNumber_Recursion());
  }

  @Test
  public void getNumber_Iteration() throws Exception {
    System.out.println("递归二叉树的节点个数：");
    System.out.println(bt.getNumber_Iteration());
  }

  @Test
  public void levelIteration() throws Exception {
    System.out.println("分层遍历：");
    bt.levelIteration();
  }

  @Test
  public void getDepth_Recursion() throws Exception {
    System.out.println("递归二叉树的深度：");
    System.out.println(bt.getDepth_Recursion());
  }

  @Test
  public void getDepth_Iteration() throws Exception {
    System.out.println("迭代二叉树的深度：");
    System.out.println(bt.getDepth_Iteration());
  }

  @Test
  public void isBalanced() throws Exception {
    System.out.println("二叉树是平衡二叉树？");
    System.out.println(bt.isBalanced());
  }

  @Test
  public void maxDistance() throws Exception {
    System.out.println("二叉树的最大距离：");
    System.out.println(bt.maxDistance());
  }

  @Test
  public void width() throws Exception {
    System.out.println("二叉树的宽度：");
    System.out.println(bt.width());
  }

  @Test
  public void findPath() throws Exception {
    List<Integer> path = new ArrayList<>();
    bt.findPath(5, path);
    for (Integer i: path)
      System.out.print(i + " ");
  }

  @Test
  public void getLCA() throws Exception {
    System.out.println(bt.getLowestCommonAncestor(6, 9));
  }
}