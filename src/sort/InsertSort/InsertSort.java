package sort.InsertSort;

import sort.sort;

/**
 * Created by 西铭 on 2016/5/9.
 * 主要思想 初始时假设第一个记录自成一个有序序列，其余记录为无序序列。接着从第二个记录开始，按照记录的的大小
 *        依次将当前处理的记录插入到其之前的有序序列中，直到最后一个记录插入到有序序列中为止。
 * 时间复杂度  最好：O（n）, 最坏：O（n^2）, 平均：O（n^2）
 * 空间复杂度  O（1）
 * 稳定
 */
public class InsertSort<T extends Comparable<T>> implements sort<T> {
    @Override
    public void sort(T[] arrays) {
        if(arrays == null || arrays.length <= 1)
            return;
        int length = arrays.length;
        for(int i = 1; i < length; i++){
            if(arrays[i].compareTo(arrays[i - 1]) >= 0)
                continue;
            T target = arrays[i];
            int j = i - 1;
            while(j >= 0 && arrays[j].compareTo(target) > 0){
                arrays[j + 1] = arrays[j];
                j--;
            }
            arrays[j + 1] = target;
        }
    }
}
