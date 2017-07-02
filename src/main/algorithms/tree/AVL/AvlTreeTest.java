package algorithms.tree.AVL;

/**
 * Created by 西铭 on 2016/5/9.
 */
public class AvlTreeTest {
    private static int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};

    public static void main(String[] args) {
        int i;
        AvlTree<Integer> tree = new AvlTree<>();

        System.out.printf("== 依次添加: ");
        for(i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        System.out.printf("\n== 前序遍历: ");
        tree.preOrder();

        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();

        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== 高度: %d\n", tree.height());
        System.out.printf("== 最小值: %d\n", tree.minimum());
        System.out.printf("== 最大值: %d\n", tree.maximum());

        i = 12;
        System.out.printf("\n== 删除根节点: %d", i);
        tree.remove(i);
        tree.remove(10);
        tree.print();

        System.out.printf("\n== 高度: %d", tree.height());
        System.out.printf("\n== 前序遍历: ");
        tree.preOrder();
    }
}
