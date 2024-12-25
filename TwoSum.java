import java.util.*;

public class TwoSum {

    /* Time Complexity Analysis:
       1. The outer loop runs n times (once for each element in the array).
       2. For each iteration of the outer loop, the binary search inside the loop runs in O(log n) time.
       3. Thus, the total time complexity for the combined loop and binary search is O(n * log n).
    */
    public static int[] findIndexOfElementsUsingSortingAndBinarySearch(int[] arr, int target) {

        int[] tempArr = Arrays.copyOf(arr, arr.length);
        int[] result = new int [2];
        int[] twoSumElements = new int[2];  // Store values (not indices)
        int leftPtr = 0;
        int rightPtr = 0;
        int mid = 0;

        // Sort the temporary array
        Arrays.sort(tempArr);

        // Find the two elements that sum up to the target
        for (int i = 0; i < tempArr.length; i++) {
            int complement = target - tempArr[i];
            leftPtr = i + 1;
            rightPtr = tempArr.length - 1;

            // Binary search for the complement
            while (leftPtr <= rightPtr) {
                mid = (leftPtr + rightPtr) / 2;

                if (tempArr[mid] == complement) {
                    twoSumElements[0] = tempArr[i];  // First element
                    twoSumElements[1] = tempArr[mid]; // Second element                   
                    break; // Exit binary search once we find a pair
                } else if (tempArr[mid] < complement) {
                    leftPtr = mid + 1;
                } else {
                    rightPtr = mid - 1;
                }
            }

        }

        // Now, map the values back to their original indices
        int m = 0;

//      System.out.println(twoSumElements[0]);
//      System.out.println(twoSumElements[1]);

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == twoSumElements[m]) {
                result[m] = j;  // Store the original index
                m++;
                break;
            }
        }

        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == twoSumElements[m]) {
                result[m] = k;  // Store the original index
                m++;
                break;
            }
        }

        return result;
    }


    public static int [] findIndexOfElementsUsingHashMap(int[] arr, int target){

        Map<Integer,Integer> map = new HashMap<>();
        int complement = 0;
        int [] result = {-1,-1};

        for(int i = 0; i < arr.length; i++){
           complement = target - arr[i];

           if(map.containsKey(complement)){
//             result[0] = i;
//             result[1] = map.get(complement);
               return new int[]{map.get(complement),i};

           }else{
               map.put(arr[i], i);
           }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 8, 1, 3};
        int target = 11;

        int[] result1 = findIndexOfElementsUsingSortingAndBinarySearch(arr, target);

        System.out.println("Using BinarySearch : " + Arrays.toString(result1));

        int[] result2 = findIndexOfElementsUsingSortingAndBinarySearch(arr, target);

        System.out.println("Using HashMap : " + Arrays.toString(result2));
    }
}
