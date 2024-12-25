import java.util.Arrays;

public class PartitionArraySuchThatMaxDiffIsK{

     
     public static int minimizeNumOfSubseqSuchThatDiffBtwMaxAndMinValInEachSubseqIsAtMostK(int [] arr, int atmostDiff){

        if(arr.length <= 1)
            return arr.length;

        Arrays.sort(arr);     // Helps to decide boundaries for each subsequence

        int ans = 1;

        int min = arr[0];

        for(int i = 1; i < arr.length; i++){

            if(arr[i] - min > atmostDiff){    // Current element is out of bound of atmostDiff
                min = arr[i];                 // Thus it will be a part of another subsequence
                ans++;
            }else{
                                              // Element is within the range of atmostDiff
            }
               
        } 

        return ans;    
     }

     public static void main(String [] args){
    
          int [] arr = {3,6,1,2,5};
          int atmostDiff = 2;
      
          int result = PartitionArraySuchThatMaxDiffIsK.minimizeNumOfSubseqSuchThatDiffBtwMaxAndMinValInEachSubseqIsAtMostK(arr,atmostDiff);
          System.out.println(result);

     }

}