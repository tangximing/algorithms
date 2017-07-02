package algorithms.sort;

/**
 * Created by 西铭 on 2016/5/9.
 * the interface for Sort algorithms
 */
public interface Sort<T extends Comparable<T>> {
    void sort(T[] arrays);
    default void print(T[] arrays){
        for(T item: arrays)
            System.out.print(item.toString() + " ");
        System.out.println();
    }
}
