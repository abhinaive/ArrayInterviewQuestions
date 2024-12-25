import java.util.*;


public class ReplaceElementsInArray{

     public static int [] replaceElementInArrayForGivenMapping(int [] arr, int [][] mappingArr){

          Map <Integer, Integer> map = new HashMap<>();

          for(int i = 0; i < arr.length; i++){
               map.put(arr[i],i);
          }

          for(int [] keyVal : mappingArr){
               
               int oldVal = keyVal[0];
               int newVal = keyVal[1];

               int indexOfOldElemInOrigArr = map.get(oldVal);

               arr[indexOfOldElemInOrigArr] = newVal;

               map.put(newVal,indexOfOldElemInOrigArr);  // Making new entry in map for updated key = newVal

               map.remove(oldVal);                       // Removing old entry in map key = oldVal
          }

          return arr;
     }

     public static void main(String [] args){

          int [] arr = {1,2,4,6};
          int [][] mappingArr = {{1, 3}, {4, 7}, {6, 1}}; 

          int [] resultingArr = ReplaceElementsInArray.replaceElementInArrayForGivenMapping(arr,mappingArr);      

          for(int ele : resultingArr){
               System.out.print(ele + ", ");  // 3, 2, 7, 1,
          }
     }
} 