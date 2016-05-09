package sort.InsertSort;

/**
 * Created by 西铭 on 2016/5/9.
 * test for insert sort
 */
public class InsertSortTest {
    public static void main(String[] args){
        Integer[] arrays = {3,6,2,8,1,4,7,5,0};
        InsertSort<Integer> bubbleSort = new InsertSort<>();
        bubbleSort.sort(arrays);
        bubbleSort.print(arrays);
    }
}
