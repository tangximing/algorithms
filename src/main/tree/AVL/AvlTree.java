package tree.AVL;

/**
 * Created by 西铭 on 2016/5/9.
 */
public class AvlTree<T extends Comparable<T>> {
    /**
     * root for AVL tree
     */
    public AvlTreeNode root;

    /**
     * class for the node in avl tree
     */
    class AvlTreeNode{
        public T data;
        public AvlTreeNode left;
        public AvlTreeNode right;
        public int height;
        public AvlTreeNode(T data, AvlTreeNode left, AvlTreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 1;
        }
    }

    public AvlTree(){
        root = null;
    }

    /**
     * insert key to the tree
     * @param key
     */
    public void insert(T key){
        this.root = insert(this.root, key);
    }

    private AvlTreeNode insert(AvlTreeNode tree, T key){
        if(tree == null){
            tree = new AvlTreeNode(key, null, null);
            return tree;
        }
        /**
         * key值小于root的值,则插入左子树; key值大于root的值,则插入右子树
          */
        if(key.compareTo(tree.data) < 0){
            tree.left = insert(tree.left, key);
            /**
             * 插入key值后出现不平衡，需要调整
             */
            if(height(tree.left) - height(tree.right) == 2){
                /**
                 * left left rotation
                 */
                if(key.compareTo(tree.left.data) < 0){
                    tree = leftleftRotation(tree);
                }else if(key.compareTo(tree.left.data) > 0){
                    tree = leftrightRotation(tree);
                }
            }
        } else if(key.compareTo(tree.data) > 0){
            tree.right = insert(tree.right, key);
            if(height(tree.right) - height(tree.left) == 2){
                if(key.compareTo(tree.right.data) < 0){
                    tree = rightleftRotation(tree);
                }else if(key.compareTo(tree.right.data) > 0){
                    tree = rightrightRotation(tree);
                }
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    /**
     * remove the node of the value "key"
     * @param key
     * @return
     */
    public AvlTreeNode remove(T key){
        AvlTreeNode target = search(key);
        if(target != null){
            return remove(root, target);
        }
        return root;
    }
    private AvlTreeNode remove(AvlTreeNode tree, AvlTreeNode target){
        if(tree == null || target == null)
            return null;
        int cmp = tree.data.compareTo(target.data);
        if(cmp > 0){
            tree.left = remove(tree.left, target);
            if(height(tree.right) - height(tree.left) == 2){
                if(height(tree.right.left) > height(tree.right.right)){
                    tree = rightleftRotation(tree);
                } else {
                    tree = rightrightRotation(tree);
                }
            }
        } else if(cmp < 0){
            tree.right = remove(tree.right, target);
            if(height(tree.left) - height(tree.right) == 2){
                if(height(tree.left.right) > height(tree.left.left)){
                    tree = leftrightRotation(tree);
                } else {
                    tree = leftleftRotation(tree);
                }
            }
        } else {
            /**
             * 1. if the left and right child are both not null
             * 2. if the height of the left child is bigger than the height of the right child
             *    then replace it with the maximum node of the left child;
             * 3. else
             *    replace it with the minimum node of the right child.
             */
            if(tree.left != null && tree.right != null){
                if(height(tree.left) > height(tree.right)){
                    AvlTreeNode max = max(tree.left);
                    tree.data = max.data;
                    tree.left = remove(tree.left, max);
                } else {
                    AvlTreeNode min = min(tree.right);
                    tree.data = min.data;
                    tree.right = remove(tree.right, min);
                }
            } else {
                /**
                 * if the left or right is null, just assign the tree to its' left child of right child
                 */
                AvlTreeNode tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                tmp = null;
            }
        }
        /**
         * update the height of the tree after deletion
         */
        if(tree != null)
            tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    /**
     * get the max value of the tree
     * @return
     */
    public T maximum(){
        AvlTreeNode max = max(root);
        if(max != null)
            return max.data;
        return null;
    }
    private AvlTreeNode max(AvlTreeNode tree){
        if(tree == null)
            return null;
        while(tree.right != null)
            tree = tree.right;
        return tree;
    }

    /**
     * get the min value of the tree
     * @return
     */
    public T minimum(){
        AvlTreeNode min = min(root);
        if(min != null)
            return min.data;
        return null;
    }
    private AvlTreeNode min(AvlTreeNode tree){
        if(tree == null)
            return null;
        while(tree.left != null)
            tree = tree.left;
        return tree;
    }

    /**
     * search the node of the key
     * @param key
     * @return
     */
    public AvlTreeNode search(T key){
        return search(root, key);
    }
    private AvlTreeNode search(AvlTreeNode tree, T key){
        if(tree == null)
            return null;
        int cmp = tree.data.compareTo(key);
        if(cmp > 0)
            return search(tree.left, key);
        else if(cmp < 0)
            return search(tree.right, key);
        else
            return tree;

    }

    /**
     * left left rotation for unbalanced tree node
     * @param node
     * @return
     */
    private AvlTreeNode leftleftRotation(AvlTreeNode node){
        AvlTreeNode left = node.left;
        node.left = left.right;
        left.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        left.height = Math.max(height(left.left), node.height) + 1;
        return left;
    }

    /**
     * right right rotation for unbalanced tree node
     * @param node
     * @return
     */
    private AvlTreeNode rightrightRotation(AvlTreeNode node){
        AvlTreeNode right = node.right;
        node.right = right.left;
        right.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        right.height = Math.max(height(node.left), node.height) + 1;
        return right;
    }

    /**
     * left right rotation for unbalanced tree
     * @param node
     * @return
     */
    private AvlTreeNode leftrightRotation(AvlTreeNode node){
        node.left = rightrightRotation(node.left);
        return leftleftRotation(node);
    }

    /**
     * right left rotation for unbalanced tree
     * @param node
     * @return
     */
    private AvlTreeNode rightleftRotation(AvlTreeNode node){
        node.right = leftleftRotation(node.right);
        return rightrightRotation(node);
    }

    /**
     * get the height of the tree
     * @return
     */
    public int height(){
        return height(root);
    }
    private int height(AvlTreeNode tree){
        if(tree == null)
            return 0;
        return tree.height;
    }

    /**
     * preOrder
     */
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(AvlTreeNode root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * inOrder
     */
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(AvlTreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    /**
     * postOrder
     */
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(AvlTreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void print(AvlTreeNode tree, T key, int direction) {
        if(tree != null) {
            if(direction==0)	// tree是根节点
                System.out.printf("%2d is root\n", tree.data, key);
            else				// tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.data, key, direction==1?"right" : "left");

            print(tree.left, tree.data, -1);
            print(tree.right,tree.data,  1);
        }
    }

    /**
     * pring the avl tree
     */
    public void print() {
        if (root != null)
            print(root, root.data, 0);
    }
}
