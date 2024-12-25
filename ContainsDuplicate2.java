import java.util.*;

public class ContainsDuplicate2{

    /*
       Variations of remove() method.
       1. Integer value = map.remove("apple");  // Removes the entry for "apple" and returns the valsue associated with key
       2. boolean removed = map.remove("apple", 10);  // Removes the entry for "apple" only if its value is 10 and returns true
    */    

    public static boolean findIfDuplicateElementArePresentWithinDistanceK(int [] arr, int k){
 
          Map<Integer,Integer> map = new HashMap<>();


          for(int i = 0; i < arr.length; i++){

              if(map.containsKey(arr[i])){
                  if(i - map.get(arr[i]) < k){
                      System.out.println(map.get(arr[i]));
                      System.out.println(i);
                      return true;
                  }else{
                    map.remove(arr[i]);
                    map.put(arr[i], i);
                  }
              }else{
                  map.put(arr[i], i);
              }

          }

          return false;
    }
        

    public static void main(String [] args){
 
        int [] arr = {1,2,3,4,1,9,1,7};
        int k = 3;
         
        System.out.println(findIfDuplicateElementArePresentWithinDistanceK(arr,k));

    }

}