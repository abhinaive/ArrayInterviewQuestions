

public class FindMinimumInRotatedSortedArray{

    public static int findMinimumElementInRotatedSortedArray(int [] arr){

          int leftPtr = 0;
          int rightPtr = arr.length - 1;
          int mid = 0;
          
          while(leftPtr < rightPtr){

               mid = (leftPtr + rightPtr)/2;

               if(arr[mid] < arr[mid - 1]  && arr[mid] < arr[mid + 1]){
                   return arr[mid];
               }else if(arr[leftPtr] < arr[mid]){
                   leftPtr = mid;
               }else{
                   rightPtr = mid;
               }

          }

          return Integer.MAX_VALUE;

    }

    public static void main(String [] args){

        int [] arr = {7,8,9,0,1,2,3,4,5,6};
    //  int [] arr = {4,5,6,7,-2,1,2};        

        System.out.println(findMinimumElementInRotatedSortedArray(arr));
         
    }

}
