package algorithms.tree.Binary;

import java.util.Collection;

/**
 * Created by tangxm on 2016/9/20.
 */
public class BinarySearchTree extends BinaryTree<Integer> {
  /**
   * insert value
   * @param value value
   */
  public void insert(Integer value) {
    root = insert(root, value);
  }
  private BinaryTreeNode insert(BinaryTreeNode node, Integer value) {
    if (node == null) {
      node = new BinaryTreeNode(value);
      return node;
    }
    if (node.data > value) {
      node.left = insert(node.left, value);
    } else {
      node.right = insert(node.right, value);
    }
    return node;
  }

  /**
   * add items to the BST
   * @param items items
   */
  public void addAll(Collection<Integer> items) {
    items.forEach(this::insert);
  }

  /**
   * 1. find the node with the mix distance to the given value
   * @param value the given value
   * @return the node's data
   */
  public int findMinDistance(int value) {
    if (root == null) {
      return -1;
    }
    return findMinDistance(root, value);
  }
  private int findMinDistance(BinaryTreeNode node, int value) {
    if (node.data == value || (node.left == null && node.right == null)) {
      return node.data;
    }
    int child;
    if (node.data > value) {
      if (node.left == null) {
        return node.data;
      }
      child = findMinDistance(node.left, value);
    } else {
      if (node.right == null) {
        return node.data;
      }
      child = findMinDistance(node.right, value);
    }

    if (Math.abs(node.data - value) <= Math.abs(child - value)) {
      return node.data;
    } else {
      return child;
    }
  }
}
