
public class MedianOfTwoSortedArrays{

    /*
     * Logic : 
     * 
     * arrX = {x1 x2 | x3 x4 x5 x6}
     * arrY = {y1 y2 y3 y4 y5 | y6 y7 y8}
     * Binary search to find every element on left side is less than every element on right.
     * Partition (|) for {arrX + arrY} = (arrX.length + arrY.length + 1)/2
     * Partition (|) for arrX = arrX.length/2
     * Partition (|) for arrY = [(arrX.length + arrY.length + 1)/2] - arrX.length/2
     * Median in case total elements is even = Avg[max(x2,y5) & min(x3,y6)]
     * Median in case total elements is odd  = max(x2,y5)
     * 
     * Note : We focus the binary search on partition for arrX for setting the search area
     */


    public static double findMedianOfTwoSortedArraysDespiteOfTotalElementsBeingOddEven(int [] arrX, int [] arrY){

        // Switch the inputs so that smaller array is first argument if function
        if(arrX.length > arrY.length){
            return findMedianOfTwoSortedArraysDespiteOfTotalElementsBeingOddEven(arrY,arrX);
        }
        
        int leftPtr = 0;
        int rightPtr = arrX.length;

        while(leftPtr <= rightPtr){

            int partitionX = (leftPtr + rightPtr)/2;
            int partitionY = (arrX.length + arrY.length + 1)/2 - partitionX;

            // If there are no element in either partition then place either -INF or +INF
            int leftPartX = (partitionX == 0) ? Integer.MIN_VALUE : arrX[partitionX - 1];
            //int rightPartY = (partitionY == 0) ? Integer.MAX_VALUE : arrY[partitionY + 1];
            int rightPartY = (partitionY == 0) ? Integer.MAX_VALUE : arrY[partitionY];

            // If there are no element in either partition then place either -INF or +INF
            int leftPartY = (partitionY == 0) ? Integer.MIN_VALUE : arrY[partitionY - 1];
            //int rightPartX = (partitionX == 0) ? Integer.MAX_VALUE : arr[partitionX + 1];
            int rightPartX = (partitionX == 0) ? Integer.MAX_VALUE : arrX[partitionX];

            if(leftPartX <= rightPartY && leftPartY  <= rightPartX){

                // Depending upon total elements being even or odd decide the median
                if((arrX.length + arrY.length)%2 == 0){
                    return ((double) Math.max(leftPartX, leftPartY) + Math.min(rightPartX, rightPartY)) / 2;
                }else{
                    return Math.max(leftPartX,leftPartY);
                }

            }else if(leftPartX > rightPartY){
                rightPtr = partitionX - 1;  // Move left in arrX
            }else{
                leftPtr = partitionX + 1;   // Move right in arrX
            }
        }

        return 0;

    }

    public static void main(String [] args){

        int [] arrX = {1,3,8,9,15};
        int [] arrY = {7,11,18,19,21,25};

        System.out.println(findMedianOfTwoSortedArraysDespiteOfTotalElementsBeingOddEven(arrX,arrY));

    }
}