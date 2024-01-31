package sorting.divideAndConquer;
import util.Util;
import sorting.AbstractSorting;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        if( leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length){
            int pivot = partition(array, leftIndex, rightIndex);
            sort(array, pivot + 1, rightIndex);
            sort(array, leftIndex, pivot - 1);
        }
    }
	

    private Integer partition(T[] array, int leftIndex, int rightIndex){
        int j = leftIndex; 
        for (int i = leftIndex + 1; i <= rightIndex; i++){
           if( array[i].compareTo(array[leftIndex]) < 0){
            j++;
            Util.swap(array, j, i);
           }
        }
        Util.swap(array, leftIndex, j);
        return j;
    }

}
