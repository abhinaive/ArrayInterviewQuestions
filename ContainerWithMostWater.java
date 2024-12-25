
public class ContainerWithMostWater{

    public static int findAreaOfContainerHoldingMaximumVolumeOfWater(int [] heightArr){

        int leftPtr = 0;
        int rightPtr = heightArr.length - 1;
        int maxAreaSoFar = 0;
        
        while(leftPtr < rightPtr){
   
             int runtimeHeight = Math.min(heightArr[leftPtr],heightArr[rightPtr]);

             maxAreaSoFar = Math.max(maxAreaSoFar,runtimeHeight*(rightPtr - leftPtr));

             if(heightArr[leftPtr] <= heightArr[rightPtr]){
                 leftPtr++;
             }else{
                 rightPtr--;
             }

        }

        return maxAreaSoFar;

    }

    public static void main(String [] args){

         int [] heightArr = {1,8,6,2,5,4,8,3,7};

         System.out.println(findAreaOfContainerHoldingMaximumVolumeOfWater(heightArr));         

    }
}