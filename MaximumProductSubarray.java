

public class MaximumProductSubarray{


    public static int findMaxProductContiguousSubarray(int [] arr){
          int maxRunningProduct = arr[0];
          int minRunningProduct = arr[0];
          int maxProd = minRunningProduct;

          for(int i = 1; i < arr.length; i++){
           
               int currElement = arr[i];
               //minRunningProduct*currElement = -ve*-ve
               //maxRunningProduct*currElement = +ve*+ve
               //currElement                   = in case previous running product is smaller than current element
               int tempMax = Math.max(currElement, Math.max(minRunningProduct*currElement,maxRunningProduct*currElement));
               minRunningProduct = Math.min(currElement, Math.min(minRunningProduct*currElement,maxRunningProduct*currElement));
               maxRunningProduct = tempMax;  // We used maxRunningProduct in above statement, so took temp variable to store its value.

               maxProd = Math.max(maxRunningProduct,maxProd);

          }

          return maxProd;
    }

    public static void main(String [] args){

        int [] arr = {2,3,-2,4};

        System.out.println(findMaxProductContiguousSubarray(arr));  // 6

    }

}