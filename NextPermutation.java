import java.util.*;

/***************************************************************************************************/ 
/*                                          Logic :                                                */
/* Traverse from right of given array and find the position where incresing order from right become*/ 
/* out of order. Find out the immmediate larger number than the number which is out of order found */
/* from the right side. Swap those two numbers i.e. out of order number <-> immediate larger number*/
/* than out of order number. Reverse the array from just after the swap positon till the right end */
/***************************************************************************************************/

public class NextPermutation{

    public static void swapPositionToReverseArray(int [] arr, int i, int j){
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


     public static void swapPositionOfOutOfOrderAndNextGreaterDigitToIt(int [] arr, int elementIdx, int nextGreaterElementIdx){
         int temp =  arr[elementIdx];
         arr[elementIdx] = arr[nextGreaterElementIdx];
         arr[nextGreaterElementIdx] = temp;
     }

     public static void reverseRestOfArrayFromNextToSwapPositonTillEnd(int [] arr, int i){

        int j = arr.length - 1;
        while(i < j){
            swapPositionToReverseArray(arr,i,j);
            i++;
            j--;
        }
     }

     public static void nextPermutationJustGreaterThanTheGivenNumber(int [] arr){

          int rightPtr = arr.length - 2;

          while(rightPtr >= 0 && arr[rightPtr + 1] <= arr[rightPtr]){  // When loop ends we will have the idx of out of order element 
              rightPtr--;
          }

          if(rightPtr >= 0){
              int nextGreterElemIdx = arr.length - 1;

              while(arr[rightPtr] >= arr[nextGreterElemIdx]){  // When loop ends we will have the idx of next greater elem to swapped element at rightPtr
                nextGreterElemIdx--;
              }

              swapPositionOfOutOfOrderAndNextGreaterDigitToIt(arr, rightPtr, nextGreterElemIdx);
          }

          reverseRestOfArrayFromNextToSwapPositonTillEnd(arr, rightPtr + 1);

          System.out.println(Arrays.toString(arr));
     }

     public static void main(String [] args){

    //  int [] arr = {1,2,3};     // 1 3 2
        int [] arr = {2,5,4,3,1}; // 3 1 2 4 5

        NextPermutation.nextPermutationJustGreaterThanTheGivenNumber(arr);
     } 

}