package sorting.divideAndConquer.hybridMergesort;
import util.Util;
import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= 0 && leftIndex < rightIndex && rightIndex <= array.length){
            if(array.length <= SIZE_LIMIT){
                insertionSort(array, leftIndex, rightIndex);
                INSERTIONSORT_APPLICATIONS ++;
            }else{
                mergeSort(array, leftIndex, rightIndex);
                MERGESORT_APPLICATIONS ++;
            }
			}
		}


    private void insertionSort(T[] array, int leftIndex, int rightIndex) {
        for(int i = leftIndex; i <= rightIndex; i++){
            int j = i + 1;
            while (j > leftIndex && j <= rightIndex){
                if(array[j].compareTo(array[j-1]) < 0){
                Util.swap(array, j, j-1);
                }
                j--;
            }
            }
        }


	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
            int meio = (rightIndex + leftIndex) / 2;
            sort(array, leftIndex, meio);
            sort(array, meio + 1, rightIndex);
            merge(array, leftIndex, meio, rightIndex);
        
    }

    private void merge(T[] array, int comeco, int meio, int fim) {
        T[] aux = (T[]) new Comparable[array.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = array[i];
        }

        int i = comeco;
        int j = meio + 1;
        int k = comeco;

        while (i <= meio && j <= fim) {
            if (aux[i].compareTo(aux[j]) <= 0) {
                array[k] = aux[i];
                i++;
            } else {
                array[k] = aux[j];
                j++;
            }
            k++;
        }
		while (i <= meio) {
            array[k] = aux[i];
            i++;
            k++;
        }

        while (j <= fim) {
            array[k] = aux[j];
            j++;
            k++;
        }
    }
}

