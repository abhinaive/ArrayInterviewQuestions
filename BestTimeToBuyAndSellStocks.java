
public class BestTimeToBuyAndSellStocks{
    // LOGIC :
    // Minimize the Buying Price at any moment
    // Maximize the Profit = currentStockValue - minimum buying price
    public static int [] findBuyAndSellPriceOfStockToMaximizeProfit(int [] stocksArr){

         int [] buyAndSellPrice = new int[2];
         int minBuyingPrice = stocksArr[0];
         int maxSellingPrice = 0;
         int maxProfit = 0;

         for(int i = 0; i < stocksArr.length; i++){
            
              if(stocksArr[i] < minBuyingPrice){
                minBuyingPrice = stocksArr[i];
              }

              maxProfit = Math.max(maxProfit,stocksArr[i] - minBuyingPrice);
              maxSellingPrice = maxProfit + minBuyingPrice;
            
         }

         return new int []{minBuyingPrice,maxSellingPrice};
        
    }

    public static void main(String [] args){

         int [] stocksArr = {7,1,5,3,6,4};

         int [] buyAndSellPrice = findBuyAndSellPriceOfStockToMaximizeProfit(stocksArr);

         System.out.println("Buying Price : " + buyAndSellPrice[0]);
         System.out.println("Selling Price : " + buyAndSellPrice[1]);

    }
}