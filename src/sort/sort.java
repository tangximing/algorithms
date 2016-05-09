package sort;

/**
 * Created by 西铭 on 2016/5/9.
 * the interface for sort algorithms
 */
public interface sort<T extends Comparable<T>> {
    void sort(T[] arrays);
    default void print(T[] arrays){
        for(T item: arrays)
            System.out.println(item.toString());
    }
}
