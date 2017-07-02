package algorithms.tree.RedBlack;

import java.util.List;

/**
 * Created by tangxm on 2016/8/8. 红黑树五条性质：
 * 1. 任意节点颜色或者红色，或者黑色
 * 2. 根节点颜色为黑色
 * 3.叶子节点颜色为黑色（红黑树中叶子节点为NULL）
 * 4. 红色节点的两个儿子颜色均为黑色
 * 5. 对每个节点，从当前节点到任意后裔叶子节点路径上的黑色节点个数相同
 */
public class RBTree<T extends Comparable<T>> {

  private RBTNode root;   // 保存树的根节点
  private static final boolean Red = false;   // 红色
  private static final boolean Black = true;   // 黑色

  /**
   * 红黑树节点
   */
  private class RBTNode {
    T key;
    RBTNode left;
    RBTNode right;
    RBTNode parent;
    boolean color;

    public RBTNode(T key, RBTNode left, RBTNode right, RBTNode parent, boolean color) {
      this.key = key;
      this.left = left;
      this.right = right;
      this.parent = parent;
      this.color = color;
    }
  }

  /**
   * preOrder
   */
  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(RBTNode root) {
    if (root != null) {
      System.out.print(root.key + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  /**
   * inOrder
   */
  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(RBTNode root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.key + " ");
      inOrder(root.right);
    }
  }

  /**
   * postOrder
   */
  public void postOrder() {
    postOrder(root);
  }

  private void postOrder(RBTNode root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.key + " ");
    }
  }

  /**
   * 插入list
   *
   * @param list algorithms.algorithms.list
   */
  public void insert(List<T> list) {
    list.forEach(this::insert);
  }

  /**
   * 插入节点至红黑树
   *
   * @param key 即将插入的节点
   */
  public void insert(T key) {
    RBTNode node = new RBTNode(key, null, null, null, Black);
    insert(node);
  }

  private void insert(RBTNode node) {
    if (this.root == null) {
      this.root = node;
      return;
    }

    int cmp;
    RBTNode pre = root, c = root;
    while (c != null) {
      pre = c;
      cmp = node.key.compareTo(c.key);
      if (cmp < 0) {
        c = c.left;
      } else if (cmp > 0) {
        c = c.right;
      } else {
        c.key = node.key;
        return;
      }
    }

    node.parent = pre;
    cmp = node.key.compareTo(pre.key);
    if (cmp < 0) {
      pre.left = node;
    } else {
      pre.right = node;
    }

    node.color = Red;
    insertFixUp(node);
  }

  private void insertFixUp(RBTNode c) {
    RBTNode parent, gParent, uncle;
    // 若父节点颜色为红色，则违背红黑树规则
    while ((parent = parentOf(c)) != null && colorOf(parent) == Red) {
      gParent = parentOf(parent);
      // 若父节点是祖父节点的左孩子
      if (parent == gParent.left) {
        uncle = gParent.right;
        // Case 1: 叔叔节点是红色
        if (colorOf(uncle) == Red) {
          parent.color = Black;
          uncle.color = Black;
          gParent.color = Red;
          c = gParent;
        } else {
          // Case 2: 叔叔节点是黑色，当前节点是父节点右孩子
          if (c == parent.right) {
            RBTNode tmp;
            leftRotation(parent);
            tmp = parent;
            parent = c;
            c = tmp;
          }
          // Case 3: 叔叔节点是黑色，当前节点是左孩子
          parent.color = Black;
          gParent.color = Red;
          rightRotation(gParent);
        }
      } else {
        uncle = gParent.left;
        if (colorOf(uncle) == Red) {
          parent.color = Black;
          uncle.color = Black;
          gParent.color = Red;
          c = gParent;
        } else {
          if (c == parent.left) {
            RBTNode tmp;
            rightRotation(parent);
            tmp = parent;
            parent = c;
            c = tmp;
          }

          parent.color = Black;
          gParent.color = Red;
          leftRotation(gParent);
        }
      }

      this.root.color = Black;
    }
  }

  public void remove(T key) {
    RBTNode node;

    if ((node = search(key)) != null)
      remove(node);
  }

  private void remove(RBTNode node) {
    RBTNode child, parent;
    boolean color;

    // 被删除节点的"左右孩子都不为空"的情况。
    if ((node.left != null) && (node.right != null)) {
      // 被删节点的后继节点。(称为"取代节点")
      // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉
      // 获取后继节点
      RBTNode replace = node.right;
      while (replace.left != null)
        replace = replace.left;

      // "node节点"不是根节点(只有根节点不存在父节点)
      if (parentOf(node) != null) {
        if (parentOf(node).left == node)
          parentOf(node).left = replace;
        else
          parentOf(node).right = replace;
      } else {
        // "node节点"是根节点，更新根节点。
        this.root = replace;
      }

      // child是"取代节点"的右孩子，也是需要"调整的节点"。
      // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
      child = replace.right;
      parent = parentOf(replace);
      // 保存"取代节点"的颜色
      color = colorOf(replace);

      // "被删除节点"是"它的后继节点的父节点"
      if (parent == node) {
        parent = replace;
      } else {
        // child不为空
        if (child != null)
          child.parent = parent;
        parent.left = child;

        replace.right = node.right;
        node.right.parent = replace;
      }

      replace.parent = node.parent;
      replace.color = node.color;
      replace.left = node.left;
      node.left.parent = replace;

      if (color == Black)
        removeFixUp(child, parent);

      node = null;
      return;
    }

    if (node.left != null) {
      child = node.left;
    } else {
      child = node.right;
    }

    parent = node.parent;
    // 保存"取代节点"的颜色
    color = node.color;

    if (child != null)
      child.parent = parent;

    // "node节点"不是根节点
    if (parent != null) {
      if (parent.left == node)
        parent.left = child;
      else
        parent.right = child;
    } else {
      this.root = child;
    }

    if (color == Black)
      removeFixUp(child, parent);
    node = null;
  }

  private void removeFixUp(RBTNode node, RBTNode parent) {
    RBTNode brother;

    while (isBlack(node) && (node != this.root)) {
      if (parent.left == node) {
        brother = parent.right;
        if (isRed(brother)) {
          // Case 1: x的兄弟w是红色的
          setBlack(brother);
          setRed(parent);
          leftRotation(parent);
          brother = parent.right;
        }

        if (isBlack(brother.left) && isBlack(brother.right)) {
          // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
          setRed(brother);
          node = parent;
          parent = parentOf(node);
        } else {
          if (isBlack(brother.right)) {
            // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
            setBlack(brother.left);
            setRed(brother);
            rightRotation(brother);
            brother = parent.right;
          }
          // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
          setColor(brother, colorOf(parent));
          setBlack(parent);
          setBlack(brother.right);
          leftRotation(parent);
          node = this.root;
          break;
        }
      } else {
        brother = parent.left;
        if (isRed(brother)) {
          // Case 1: x的兄弟w是红色的
          setBlack(brother);
          setRed(parent);
          rightRotation(parent);
          brother = parent.left;
        }

        if (isBlack(brother.left) && isBlack(brother.right)) {
          // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
          setRed(brother);
          node = parent;
          parent = parentOf(node);
        } else {
          if (isBlack(brother.left)) {
            // Case 3: x的兄弟w是黑色的，并且w的右孩子是红色，左孩子为黑色。
            setBlack(brother.right);
            setRed(brother);
            leftRotation(brother);
            brother = parent.left;
          }

          // Case 4: x的兄弟w是黑色的；并且左孩子是红色的，右孩子任意颜色。
          setColor(brother, colorOf(parent));
          setBlack(parent);
          setBlack(brother.left);
          rightRotation(parent);
          node = this.root;
          break;
        }
      }
    }

    setBlack(node);
  }

  /**
   * the brother of the node
   *
   * @param node current node
   * @return the brother
   */
  public RBTNode brother(RBTNode node) {
    if (node.parent == null)
      return null;
    if (node.parent.left == node)
      return node.parent.right;
    else
      return node.parent.left;
  }

  /**
   * search the node with the value
   *
   * @param key the value of the node
   * @return the node
   */
  public RBTNode search(T key) {
    if (root != null) {
      RBTNode c = root;
      while (c != null) {
        int cmp = key.compareTo(c.key);
        if (cmp == 0) {
          return c;
        } else if (cmp > 0) {
          c = c.right;
        } else {
          c = c.left;
        }
      }
    }
    return null;
  }

  /**
   * 对节点进行左旋转
   *
   * @param c 需要旋转的节点
   */
  private void leftRotation(RBTNode c) {
    /**
     * 总共需要修改六条边
     */
    RBTNode cr = c.right;               // "c的右孩子"保存至cr
    c.right = cr.left;                  // "c的右孩子" -> "cr的左孩子"

    if (cr.left != null) {
      cr.left.parent = c;               // "cr的左孩子的父亲" -> c
    }

    cr.parent = c.parent;               // "cr的父亲" -> "c的父亲"
    cr.left = c;                        // "cr的左孩子" -> c

    if (c.parent == null) {
      this.root = cr;                   // 若当前节点c为root，将cr设为root
    } else {
      if (c.parent.left == c) {         // 若当前节点是其父节点的左孩子，则将其父节点的左孩子设为cr
        c.parent.left = cr;
      } else {
        c.parent.right = cr;            // 若当前节点是其父节点的右孩子，则将其父节点的右孩子设为cr
      }
    }

    c.parent = cr;                      // "c的父亲" -> cr
  }

  /**
   * 对节点进行右旋转
   *
   * @param c 需要旋转的节点
   */
  private void rightRotation(RBTNode c) {
    /**
     * 总过需要修改六条边
     */
    RBTNode cl = c.left;
    c.left = cl.right;

    if (cl.right != null) {
      cl.right.parent = c;
    }

    cl.parent = c.parent;
    cl.right = c;

    if (c.parent == null) {
      this.root = cl;
    } else {
      if (c.parent.left == c) {
        c.parent.left = cl;
      } else {
        c.parent.right = cl;
      }
    }

    c.parent = cl;
  }

  /**
   * return parent node of the node
   *
   * @param c current node
   * @return parent
   */
  private RBTNode parentOf(RBTNode c) {
    if (c != null)
      return c.parent;
    return null;
  }

  /**
   * return color of node
   *
   * @param c current node
   * @return the color
   */
  private boolean colorOf(RBTNode c) {
    if (c != null)
      return c.color;
    return Black;
  }

  private boolean isRed(RBTNode node) {
    return ((node != null)&&(node.color == Red));
  }

  private boolean isBlack(RBTNode node) {
    return !isRed(node);
  }

  private void setBlack(RBTNode node) {
    if (node != null)
      node.color = Black;
  }

  private void setRed(RBTNode node) {
    if (node != null)
      node.color = Red;
  }

  private void setParent(RBTNode node, RBTNode parent) {
    if (node != null)
      node.parent = parent;
  }

  private void setColor(RBTNode node, boolean color) {
    if (node!=null)
      node.color = color;
  }
}
