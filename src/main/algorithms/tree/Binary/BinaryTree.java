package algorithms.tree.Binary;

import java.util.*;

/**
 * Created by 西铭 on 2016/5/10.
 * 1. Build the algorithms.algorithms.tree with the preOrder and inOrder
 * 2. Build the algorithms.algorithms.tree with the postOrder and inOrder
 * 3. Recursion: preOrder, inOrder, postOrder
 * 4. Iteration: preOrder, inOrder, postOrder
 * 5. Get the node number of the algorithms.algorithms.tree
 * 6. Level Iteration of the algorithms.algorithms.tree
 * 7. Get the depth of tht algorithms.algorithms.tree
 * 8. Judge if the algorithms.algorithms.tree is an balanced algorithms.algorithms.tree
 * 9. Get the max distance in the algorithms.algorithms.tree
 * 10. Get the width of the algorithms.algorithms.tree
 * 11. Get the path to the node from root
 * 12. Get the lowest common ancestor of two nodes
 */
public class BinaryTree<T> {
    /**
     * root for the BinaryTree
     */
    protected BinaryTreeNode root;
    public BinaryTree(){
        root = null;
    }

    /**
     * node for the BinaryTree
     */
    class BinaryTreeNode{
        public T data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public BinaryTreeNode(){}
        public BinaryTreeNode(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 1. Build the algorithms.algorithms.tree with the preOrder and inOrder
     */
    public void buildPreIn(T[] pre, T[] in){
        root = buildPreIn(Arrays.asList(pre), Arrays.asList(in));
    }
    private BinaryTreeNode buildPreIn(List<T> pre, List<T> in){
        if(pre == null || in == null || pre.size() == 0 || in.size() == 0)
            return null;
        List<T> leftpre, rightpre, leftin, rightin;
        BinaryTreeNode root = new BinaryTreeNode(pre.get(0));
        int index = in.indexOf(pre.get(0));
        if(index == -1)
            return null;
        leftpre = pre.subList(1, index + 1);
        leftin = in.subList(0, index);
        rightpre = pre.subList(index + 1, pre.size());
        rightin = in.subList(index + 1, in.size());
        root.left = buildPreIn(leftpre, leftin);
        root.right = buildPreIn(rightpre, rightin);
        return root;
    }

    /**
     * 2. Build the algorithms.algorithms.tree with the postOrder and inOrder
     */
    public void buildPostIn(T[] post, T[] in){
        root = buildPostIn(Arrays.asList(post), Arrays.asList(in));
    }
    private BinaryTreeNode buildPostIn(List<T> post, List<T> in){
        if(post == null || in == null || post.size() == 0 || in.size() == 0)
            return null;
        List<T> leftpost, rightpost, leftin, rightin;
        BinaryTreeNode root = new BinaryTreeNode(post.get(post.size() - 1));
        int index = in.indexOf(root.data);
        if(index == -1)
            return null;
        leftpost = post.subList(0, index);
        leftin = in.subList(0, index);
        rightpost = post.subList(index, post.size());
        rightin = in.subList(index + 1, in.size());
        root.left = buildPostIn(leftpost, leftin);
        root.right = buildPostIn(rightpost, rightin);
        return root;
    }
    /**
     * 3. Recursion for preOrder, inOrder, postOrder
     */
    /**
     * 3.1 preOrder
     */
    public void preOrder_Recursion(){
        preOrder_Recursion(root);
        System.out.println();
    }
    private void preOrder_Recursion(BinaryTreeNode root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder_Recursion(root.left);
            preOrder_Recursion(root.right);
        }
    }

    /**
     * 3.2 inOrder
     */
    public void inOrder_Recursion(){
        inOrder_Recursion(root);
        System.out.println();
    }
    private void inOrder_Recursion(BinaryTreeNode root){
        if(root != null){
            inOrder_Recursion(root.left);
            System.out.print(root.data + " ");
            inOrder_Recursion(root.right);
        }
    }

    /**
     * 3.3 postOrder
     */
    public void postOrder_Recursion(){
        postOrder_Recursion(root);
        System.out.println();
    }
    private void postOrder_Recursion(BinaryTreeNode root){
        if(root != null){
            postOrder_Recursion(root.left);
            postOrder_Recursion(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * 4. Iteration for preOrder, inOrder, postOrder
     */
    /**
     * 4.1 preOrder
     */
    public void preOrder_iteration(){
        preOrder_iteration(root);
        System.out.println();
    }
    private void preOrder_iteration(BinaryTreeNode root){
        if(root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            BinaryTreeNode top = stack.pop();
            System.out.print(top.data + " ");
            if(top.right != null)
                stack.push(top.right);
            if(top.left != null)
                stack.push(top.left);
        }
    }

    /**
     * 4.2 inOrder
     */
    public void inOrder_iteration(){
        inOrder_iteration(root);
        System.out.println();
    }
    private void inOrder_iteration(BinaryTreeNode root){
        if(root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.empty())
                break;
            cur = stack.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
    }

    /**
     * 4.3 postOrder
     */
    public void postOrder_iteration(){
        postOrder_iteration(root);
        System.out.println();
    }
    private void postOrder_iteration(BinaryTreeNode root){
        if(root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        /**
         * pre is used to avoid the element to enter the stack again
         */
        BinaryTreeNode pre = null;
        while(!stack.empty()){
            BinaryTreeNode top = stack.peek();
            if(top.left == null && top.right == null || pre == top.left || pre == top.right){
                System.out.print(top.data + " ");
                stack.pop();
                pre = top;
                continue;
            }
            if(top.right != null)
                stack.push(top.right);
            if(top.left != null)
                stack.push(top.left);
        }
    }

    /**
     * 5.1 Recursion: get the number of the algorithms.algorithms.tree
     */
    public int getNumber_Recursion(){
        return getNumber_Recursion(root);
    }
    private int getNumber_Recursion(BinaryTreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return getNumber_Recursion(root.left) + getNumber_Recursion(root.right) + 1;
    }

    /**
     * 5.2 Iteration: get the number of the algorithms.algorithms.tree
     */
    public int getNumber_Iteration(){
        return getNumber_Iteration(root);
    }
    private int getNumber_Iteration(BinaryTreeNode root){
        if(root == null)
            return 0;
        int count = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            BinaryTreeNode front = queue.poll();
            count++;
            if(front.left != null)
                queue.offer(front.left);
            if(front.right != null)
                queue.offer(front.right);
        }
        return count;
    }

    /**
     * 6. Level iteration of the algorithms.algorithms.tree
     */
    public void levelIteration(){
        levelIteration(root);
        System.out.println();
    }
    private void levelIteration(BinaryTreeNode root){
        if(root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            BinaryTreeNode front = queue.poll();
            System.out.print(front.data + " ");
            if(front.left != null)
                queue.offer(front.left);
            if(front.right != null)
                queue.offer(front.right);
        }
    }

    /**
     * 7.1 Recursion: Get the depth of the algorithms.algorithms.tree
     */
    public int getDepth_Recursion(){
        return getDepth_Recursion(root);
    }
    private int getDepth_Recursion(BinaryTreeNode root){
        if(root == null)
            return 0;
        return Math.max(getDepth_Recursion(root.left), getDepth_Recursion(root.right)) + 1;
    }

    /**
     * 7.2 Iteration: Get the depth of the algorithms.algorithms.tree
     * use a splitter in the queue to split tht different level
     */
    public int getDepth_Iteration(){
        return getDepth_Iteration(root);
    }
    private int getDepth_Iteration(BinaryTreeNode root){
        if(root == null)
            return 0;
        int depth = 0;
        BinaryTreeNode splitter = new BinaryTreeNode();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(splitter);
        while (!queue.isEmpty()){
            BinaryTreeNode top = queue.poll();
            if(top == splitter){
                depth++;
                if(!queue.isEmpty())
                    queue.offer(splitter);
              continue;
            }
            if(top.left != null)
                queue.offer(top.left);
            if(top.right != null)
                queue.offer(top.right);
        }
        return depth;
    }

    /**
     * 8. Judge if the algorithms.algorithms.tree is an balanced algorithms.algorithms.tree, O(n)
     */
    class Depth{
        public int height;
    }
    public boolean isBalanced(){
        return isBalanced(root, new Depth());
    }
    private boolean isBalanced(BinaryTreeNode root, Depth d){
        if(root == null){
            d.height = 0;
            return true;
        }
        Depth left = new Depth(), right = new Depth();
        if(isBalanced(root.left, left) && isBalanced(root.right, right)){
            int diff = Math.abs(left.height - right.height);
            if(diff <= 1){
                d.height = Math.max(left.height, right.height) + 1;
                return true;
            }
        }
        return false;
    }

  /**
   * 9. Get the max distance in the algorithms.algorithms.tree
   */
  public int distance = 0;
  public int maxDistance() {
    return maxDistance(root, new Depth());
  }
  private int maxDistance(BinaryTreeNode root, Depth d) {
    if (root == null) {
      d.height = 0;
      return 0;
    }
    Depth left = new Depth(), right = new Depth();
    int left_distance = maxDistance(root.left, left);
    int right_distance = maxDistance(root.right, right);
    d.height = Math.max(left.height, right.height) + 1;
    int max = Math.max(Math.max(left.height + right.height, left_distance), right_distance);
    if (max > distance) {
      distance = max;
    }
    return max;
  }

  /**
   * 10. Get the width of the algorithms.algorithms.tree
   * @return width
   */
  public int width() {
    return width(root);
  }
  private int width(BinaryTreeNode node) {
    if (root == null) {
      return 0;
    }
    int width = 1;
    int tmp = 1;
    BinaryTreeNode dummy = new BinaryTreeNode();
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.offer(node);
    queue.offer(dummy);
    while (!queue.isEmpty()) {
      BinaryTreeNode front = queue.poll();
      if (front == dummy) {
        width = Math.max(width, tmp);
        tmp = 0;
        if (!queue.isEmpty()) {
          queue.offer(dummy);
        }
        continue;
      }
      if (front.left != null) {
        queue.offer(front.left);
        tmp++;
      }
      if (front.right != null) {
        queue.offer(front.right);
        tmp++;
      }
    }
    return width;
  }

  /**
   * 11. Get the path to the node from root
   * @param value the value of the node
   * @param path the path
   * @return if find path
   */
  public boolean findPath(T value, List<T> path) {
    return findPath(root, value, path);
  }
  private boolean findPath(BinaryTreeNode node, T value, List<T> path) {
    if (node == null)
      return false;
    path.add(node.data);
    if (node.data == value)
      return true;
    if (findPath(node.left, value, path) || findPath(node.right, value, path)) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }

  /**
   * 12. Get the lowestCommonAncestor of tow nodes
   * @param value1 the value of node1
   * @param value2 the value of node2
   * @return the value of the LCA
   */
  public T getLowestCommonAncestor(T value1, T value2) {
    return getLowestCommonAncestor(root, value1, value2);
  }
  private T getLowestCommonAncestor(BinaryTreeNode node, T value1, T value2) {
    List<T> path1 = new ArrayList<>();
    List<T> path2 = new ArrayList<>();
    boolean flag1 = findPath(node, value1, path1);
    boolean flag2 = findPath(node, value2, path2);
    if (flag1 && flag2) {
      int i = 0;
      while (i < path1.size() && i < path2.size()) {
        if (path1.get(i) != path2.get(i))
          break;
        i++;
      }
      return path1.get(i - 1);
    }
    return null;
  }
}
