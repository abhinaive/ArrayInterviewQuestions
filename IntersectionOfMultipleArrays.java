import java.util.*;

public class IntersectionOfMultipleArrays{

    public static List<Integer> returnArrayOfElementsCommonInAllArrays(int [][] arr2D){
 
          // Range of numbers in each array is (1-1000) only

          int [] freq = new int[10001];
 
          for(int [] arr1D : arr2D){
             
             for(int elem : arr1D){
                 freq[elem]++;
             }
          }

          List<Integer> list = new ArrayList<>();

          int lengthOf2DArr = arr2D.length;

          for(int i = 0; i < freq.length; i++){
              if(freq[i] == lengthOf2DArr){
                  list.add(i);
              }
          }

          return list;    
    }
    

    public static void main(String [] args){

         int [][] arr2D = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};

         List <Integer> list = returnArrayOfElementsCommonInAllArrays(arr2D);

         for(int elem : list){
            System.out.println(elem);
         }

    }



}