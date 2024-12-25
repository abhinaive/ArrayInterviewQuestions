import java.util.*;

public class MaxBagsWithFullCapacityOfRocks{

     public static int findMaxNumOfBagsCanBeFullyFilledWithRocks(int [] bagCapacity, int [] alreadyOccupiedRocks, int additionalRocks){

        int [] vacancyArr = new int[bagCapacity.length];
        int countOfFullBags = 0;

        for(int i = 0; i < bagCapacity.length; i++){
            vacancyArr[i]  = bagCapacity[i] - alreadyOccupiedRocks[i];
        }

        Arrays.sort(vacancyArr);

        System.out.println(Arrays.toString(vacancyArr));

        int j = 0; 
        while(additionalRocks > 0 && j < vacancyArr.length){

           if(vacancyArr[j] == 0){
               countOfFullBags++;
               j++;
           }
           
           additionalRocks = additionalRocks - vacancyArr[j];
           countOfFullBags++; 
        }

        return countOfFullBags;

     }

     public static void main (String [] args){

        int [] bagCapacity = {2,3,4,5,10};
        int [] alreadyOccupiedRocks = {1,2,4,4,6};
        int additionalRocks = 3;

        System.out.println(MaxBagsWithFullCapacityOfRocks.findMaxNumOfBagsCanBeFullyFilledWithRocks(bagCapacity,alreadyOccupiedRocks,additionalRocks));

     }

}