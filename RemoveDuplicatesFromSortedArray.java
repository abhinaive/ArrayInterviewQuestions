
public class RemoveDuplicatesFromSortedArray{

     public static int findNumberOfUniqNumInSortedArray(int [] arr){
        
        int noOfdistictElements = 1;

        int fastPointer = 1;
        int slowPointer = 0;

        if(arr.length == 1){
            return noOfdistictElements;
        }

        while(fastPointer < arr.length){
           
            if(arr[slowPointer] == arr[fastPointer]){
                fastPointer++;
            }else{
                slowPointer = fastPointer;
                noOfdistictElements++;
            }
        }

        return noOfdistictElements;
     }
  
     public static void main(String [] args){

        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("Number of unique elements: " + findNumberOfUniqNumInSortedArray(arr));
         
     }

} 