import java.util.*;

public class SelectionSort {

    public static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int minIndex = i;

            // find minimum element
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}