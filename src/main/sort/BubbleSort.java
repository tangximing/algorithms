package sort;

import sort.Sort;

/**
 * Created by 西铭 on 2016/5/9.
 * 主题思想  对于给定的n个记录，从第一个记录开始依次对相邻的两个记录进行比较，当前面的记录大于后面的记录时
 *         交换位置，进行一轮比较和换位后，n个记录中的最大记录将位于第n位；然后对前面的n-1位进行重复的
 *         操作。
 * 时间复杂度  最好：O（n）, 最坏：O（n^2）, 平均：O（n^2）
 * 空间复杂度  O（1）
 * 稳定
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    /**
     * 优化前
     * @param arrays
     */
    @Override
    public void sort(T[] arrays) {
        if(arrays == null || arrays.length <= 1)
            return;
        int length = arrays.length;
        for(int i = 1; i <= length - 1; i++){
            for(int j = 0; j < length - i; j++){
                if(arrays[j].compareTo(arrays[j + 1]) > 0){
                    T tmp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 针对上一轮可能已经排好序，这一轮即可以不用再继续
     * @param arrays
     */
    public void betterSort(T[] arrays){
        if(arrays == null || arrays.length == 0)
            return;
        int length = arrays.length;
        boolean swapped;
        for(int i = 1; i <= length - 1; i++){
            swapped = false;
            for(int j = 0; j < length - i; j++){
                if(arrays[j].compareTo(arrays[j + 1]) > 0){
                    T tmp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }
}
