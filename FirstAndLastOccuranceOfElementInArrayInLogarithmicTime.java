
public class FirstAndLastOccuranceOfElementInArrayInLogarithmicTime{

     public static int findIndexOfFirstOccurraneTargetElementInSortedArray(int [] arr, int target){

         int firstOccurIdx = -1;
         int startPtr = 0;
         int endPtr = arr.length - 1;

         while(startPtr <= endPtr){

              int mid = (startPtr + endPtr)/2;

              if(arr[mid] == target){
                   firstOccurIdx = mid;
                   endPtr = mid - 1;
              }else if(arr[mid] > target){
                   endPtr= mid - 1;
              }else{
                   startPtr = mid + 1;
              }
         }

         return firstOccurIdx;

     }

     public static int findIndexOfLastOccurraneTargetElementInSortedArray(int [] arr, int target){
          
          int lastOccurIdx = -1;
          int startPtr = 0;
          int endPtr = arr.length - 1;

          while(startPtr <= endPtr){

               int mid = (startPtr + endPtr)/2;

               if(arr[mid] == target){
                    lastOccurIdx = mid;
                    startPtr = mid + 1;
               }else if(arr[mid] > target){
                    endPtr= mid - 1;
               }else{
                    startPtr = mid + 1;
               }
          }

          return lastOccurIdx;
     }




     public static void main(String [] args){

          int [] arr = {0,1,1,2,2,2,3,3,3,4,4,5,5,5,5};
          int target = 4;
          System.out.println("Last Occurrance Index : " + findIndexOfLastOccurraneTargetElementInSortedArray(arr,target));
          System.out.println("First Occurrance Index : " + findIndexOfFirstOccurraneTargetElementInSortedArray(arr,target));

     }

}