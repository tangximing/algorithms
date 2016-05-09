package sort.BubbleSort;

/**
 * Created by 西铭 on 2016/5/9.
 * test for BubbleSort
 */
public class BubbleSortTest {
    public static void main(String[] args){
        Integer[] arrays = {3,6,2,8,1,4,7,5,0};
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(arrays);
        bubbleSort.print(arrays);
    }
}
