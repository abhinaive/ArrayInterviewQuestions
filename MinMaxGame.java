import java.util.*;

public class MinMaxGame{

     public static int reduceArrayBasedOnMinMaxOddEvenResultTillSizeOfOne(int [] arr){
 
         List <Integer> list = new ArrayList<>();

         for(int elem : arr){
            list.add(elem);
         }

         while(list.size() > 1){
             list = processList(list);
         } 

         return list.get(0);
     }

     public static List<Integer> processList(List <Integer> input){

           List <Integer> ans = new ArrayList<>();

           for(int i = 0; i < input.size()/2;i++){                        // We traverse only half the array to get values at all indices
               if(i%2 == 0){
                   ans.add(Math.min(input.get(2*i),input.get(2*i + 1)));  // get the min of element at indexes(2*i, 2*i+1) and add it to new list
               }else{
                    ans.add(Math.max(input.get(2*i),input.get(2*i + 1))); // // get the max of element at indexes(2*i, 2*i+1) and add it to new list
               }
           }

           return ans;
     }   

     public static void main(String [] args){

            int [] arr = {1,3,5,2,4,8,2,2};

            System.out.println(MinMaxGame.reduceArrayBasedOnMinMaxOddEvenResultTillSizeOfOne(arr));

     }
}
