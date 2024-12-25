import java.util.*;

public class ContainsDuplicate1{

    public static boolean findIfArrayContainsDuplicateElements(int [] arr){

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
             
            if(set.contains(arr[i])){
                return true;
            }else{
                set.add(arr[i]);
            }
        }

        return false;

    }

    public static void main(String [] args){

         int [] arr = {1,2,3,4,5,2};
         
         System.out.println(findIfArrayContainsDuplicateElements(arr));

    }
}
