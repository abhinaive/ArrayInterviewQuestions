import java.util.Arrays;

public class MergeTwoSortedArray {

    public static int[] mergeTwoSortedArraySuchThatResultingArrayIsSorted(int[] arr1, int[] arr2) {

        int ptr1 = arr1.length - 1;
        int ptr2 = arr2.length - 1;
        int mergeArrIdx = arr1.length + arr2.length - 1;
        int[] mergeSortedArr = new int[arr1.length + arr2.length];

        // Main merging logic
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (arr1[ptr1] > arr2[ptr2]) {
                mergeSortedArr[mergeArrIdx] = arr1[ptr1];
                ptr1--;
            } else {
                mergeSortedArr[mergeArrIdx] = arr2[ptr2];
                ptr2--;
            }
            mergeArrIdx--;
        }

        // Handle leftover elements in arr1 (if any)
        while (ptr1 >= 0) {
            mergeSortedArr[mergeArrIdx] = arr1[ptr1];
            ptr1--;
            mergeArrIdx--;
        }

        // Handle leftover elements in arr2 (if any)
        while (ptr2 >= 0) {
            mergeSortedArr[mergeArrIdx] = arr2[ptr2];
            ptr2--;
            mergeArrIdx--;
        }

        return mergeSortedArr;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6,9};
        int[] arr2 = {2,4,14};

        int[] mergeSortedArr = mergeTwoSortedArraySuchThatResultingArrayIsSorted(arr1, arr2);

        System.out.println(Arrays.toString(mergeSortedArr));

        Arrays.stream(mergeSortedArr).forEach(e -> System.out.println(e));
    }
}
