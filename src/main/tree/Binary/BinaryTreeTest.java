package tree.Binary;

/**
 * Created by 西铭 on 2016/5/10.
 */
public class BinaryTreeTest {
    public static void main(String[] args){
        BinaryTree<Integer> bt = new BinaryTree<>();
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
        Integer[] in = {2, 1, 3 ,4 ,5, 7, 6 ,8, 9};

        // 1. create tree
        bt.buildPreIn(pre, in);

        // 2. iterate the tree
        System.out.println("先序遍历：");
        bt.preOrder_Recursion();
        bt.preOrder_iteration();
        System.out.println("中序遍历：");
        bt.inOrder_Recursion();
        bt.inOrder_iteration();
        System.out.println("后序遍历：");
        bt.postOrder_Recursion();
        bt.postOrder_iteration();

        System.out.println("分层遍历：");
        bt.levelIteration();

        // 3. get the number of the tree
        System.out.println("二叉树的节点个数：");
        System.out.println(bt.getNumber_Recursion() + " " + bt.getNumber_Iteration());

        // 4. get the depth of the tree
        System.out.println("二叉树的深度：");
        System.out.println(bt.getDepth_Recursion() + " " + bt.getDepth_Iteration());

        // 5. judge the tree if it's the balanced tree
        System.out.println("二叉树是平衡二叉树？");
        System.out.println(bt.isBalanced());

        // 6. get the max distance in the tree
        System.out.println("二叉树的最大距离：");
        System.out.println(bt.maxDistance());
    }
}