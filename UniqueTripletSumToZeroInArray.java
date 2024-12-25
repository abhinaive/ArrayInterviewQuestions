/* 
import java.util.*;

public class UniqueTripletSumToZeroInArray{

     
     public static List<List<Integer>> findUniqueTripletsInGivenArrayThatSumUpToZero(int [] arr){

         Arrays.sort(arr);

         System.out.println(Arrays.toString(arr));

         int leftPtr = 0;
         int rightPtr = arr.length - 1;

         List <List<Integer>> listOfTriplets = new ArrayList<>();

//       List <Integer> triplet = new ArrayList<>();


         for(int firstDigitIdx = 0; firstDigitIdx < arr.length - 2; firstDigitIdx++){

            if(arr[firstDigitIdx] > 0){  // if first element is > 0 then sum of next two elements in sorted array will never be 0;
                break;
            }

            if(arr[firstDigitIdx]  > 0 && arr[firstDigitIdx] == arr[firstDigitIdx - 1]){  // Skip the next element not the first
                continue;
            }
            
            leftPtr = firstDigitIdx + 1;
            rightPtr = arr.length - 1;

            while(leftPtr < rightPtr && arr[leftPtr] == arr[leftPtr + 1]){     // Skip duplicates for leftPtr 
                leftPtr++;
             }

            while (leftPtr < rightPtr && arr[rightPtr] == arr[rightPtr - 1]){  // Skip duplicates for rightPtr
                rightPtr--;
            }
            
            while(leftPtr < rightPtr){

                  if(arr[leftPtr] + arr[rightPtr] + arr[firstDigitIdx] == 0){

                    List<Integer> triplet = Arrays.asList(arr[firstDigitIdx], arr[leftPtr], arr[rightPtr]);
                    listOfTriplets.add(triplet);

                    leftPtr++;
                    rightPtr--;

                  }else if((arr[leftPtr] + arr[rightPtr]) + arr[firstDigitIdx] < 0){
                    leftPtr++;
                  }else{
                    rightPtr--;
                  }



            }
         }

         return listOfTriplets;
         
     }
   
     public static void main(String [] args){

         int [] arr = {-5,0,-3,5,1,-5,0,2,1};

         System.out.println(findUniqueTripletsInGivenArrayThatSumUpToZero(arr));
         
     }


}
*/

import java.util.*;

public class UniqueTripletSumToZeroInArray {

    public static List<List<Integer>> findUniqueTripletsInGivenArrayThatSumUpToZero(int[] arr) {
   
        Arrays.sort(arr); // Sort the array first
        System.out.print("Sorted Array for Debugging : ");
        System.out.println(Arrays.toString(arr)); // Debugging: Print the sorted array

        List<List<Integer>> listOfTriplets = new ArrayList<>();

        for (int firstDigitIdx = 0; firstDigitIdx < arr.length - 2; firstDigitIdx++) {

            if (arr[firstDigitIdx] > 0) { 
                // If the first element is > 0, subsequent next two elements cannot sum up to 0
                break;
            }

            if (firstDigitIdx > 0 && arr[firstDigitIdx] == arr[firstDigitIdx - 1]) {
                // Skip duplicate elements for the first digit
                continue;
            }

            int leftPtr = firstDigitIdx + 1;
            int rightPtr = arr.length - 1;

            while (leftPtr < rightPtr) {

                // Skip duplicates for leftPtr and rightPtr
                while (leftPtr < rightPtr && arr[leftPtr] == arr[leftPtr + 1]) 
                    leftPtr++;

                // Skip duplicates for leftPtr and rightPtr    
                while (leftPtr < rightPtr && arr[rightPtr] == arr[rightPtr - 1]) 
                    rightPtr--;
                
                int sum = arr[firstDigitIdx] + arr[leftPtr] + arr[rightPtr];

                if (sum == 0) {
                    // Add the triplet to the list
                    listOfTriplets.add(Arrays.asList(arr[firstDigitIdx], arr[leftPtr], arr[rightPtr]));

                    // Move pointers
                    leftPtr++;
                    rightPtr--;

                } else if (sum < 0) {
                    // Increase the sum by moving left pointer
                    leftPtr++;
                } else {
                    // Decrease the sum by moving right pointer
                    rightPtr--;
                }
            }
        }

        return listOfTriplets;
    }

    public static void main(String[] args) {
        int[] arr = {-5, 0, -3, 5, 1, -5, 0, 2, 1};

        
        List<List<Integer>> triplets = findUniqueTripletsInGivenArrayThatSumUpToZero(arr);
        System.out.print("List of Unique Triplets : ");
        System.out.println(triplets);
    }
}

