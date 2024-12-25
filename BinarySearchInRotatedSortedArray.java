
public class BinarySearchInRotatedSortedArray{



     public static int searchElementInRotatedSortedArray(int [] arr, int target){

          int leftPtr = 0;
          int rightPtr = arr.length - 1;
          int mid = 0;

          while(leftPtr <= rightPtr){

               mid = (leftPtr + rightPtr)/2;

               if(arr[mid] == target){
                   return arr[mid];
               }

               if(arr[leftPtr] <= arr[mid]){  // At any point of time either left subarray is sorted or right, from the mid 
                   
                    if(arr[leftPtr] <= target && target < arr[mid]){
                          rightPtr = mid - 1;
                    }else{
                          leftPtr = mid + 1;
                    }
               }else{                         // At any point of time either right subarray is sorted or left, from the mid
                    
                    if(arr[mid] < target && target <= arr[rightPtr]){
                         leftPtr = mid + 1;
                    }else{
                         rightPtr = mid - 1;
                    }
                      
               }
          }

          return Integer.MAX_VALUE;

     }

     public static void main(String [] args){

          int [] arr = {7,8,9,0,1,2,3,4,5,6};
          int target = 4;
          //  int [] arr = {4,5,6,7,-2,1,2};        
      
          System.out.println(searchElementInRotatedSortedArray(arr,target));
         
     }


}