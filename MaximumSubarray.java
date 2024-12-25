

public class MaximumSubarray{

    public static int findMaximumSumOfContiguousSubarray(int [] arr){

        int runningSum = 0;
        int maxRunningSum = arr[0];

        for(int i = 0; i < arr.length; i++){
             
             if(runningSum < 0){
                 runningSum = 0;  // Ignoring the contiguous cumulative sum till 'i' as it became -ve
             }

             runningSum = runningSum + arr[i];
             maxRunningSum = Math.max(maxRunningSum,runningSum);
        }

        return maxRunningSum;
    }

    public static void main(String [] args){
          
         int [] arr = {-2,1,-3,4,-1,2,1,-5,4};

         System.out.println(findMaximumSumOfContiguousSubarray(arr));  // 6
    }

}