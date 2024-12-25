import java.util.*;

public class ProductOfArrayExceptSelf{

    public static int [] returnArrayOfProductOfItsElementExceptItSelf(int [] arr){

        int [] cumulativeProdFromLeft = new int [arr.length];
        int [] cumulativeProdFromRight = new int [arr.length];
        int [] prodArrExceptSelf = new int [arr.length];

        cumulativeProdFromLeft[0] = 1; // Since there is no element in left of first element in arr.

        for(int i = 1; i < arr.length; i++){
            cumulativeProdFromLeft[i] = cumulativeProdFromLeft[i-1]*arr[i-1];
        }

        System.out.println(Arrays.toString(cumulativeProdFromLeft));

        cumulativeProdFromRight[arr.length - 1] = 1; // Since there is no element in rigth of last element in arr.

        for(int j = arr.length - 2; j > - 1; j--){
            cumulativeProdFromRight[j] = cumulativeProdFromRight[j+1]*arr[j+1];
        }

        System.out.println(Arrays.toString(cumulativeProdFromRight));

        for(int k = 0; k < arr.length; k++){
            prodArrExceptSelf[k] = cumulativeProdFromLeft[k]*cumulativeProdFromRight[k];
        }

//      System.out.println(Arrays.toString(prodArrExceptSelf));

        return prodArrExceptSelf;

    }

    public static void main(String [] args){

        int [] arr = {1,2,3,4};

        System.out.println(Arrays.toString(returnArrayOfProductOfItsElementExceptItSelf(arr)));
    }
}