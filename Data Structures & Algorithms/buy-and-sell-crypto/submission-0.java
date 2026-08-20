class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxSellPrice = prices[n - 1];
        int maxProfit = 0;
        for(int i = n - 2; i >= 0; i--){
            if(prices[i] > maxSellPrice){
                maxSellPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, maxSellPrice - prices[i]);
            }
        }
        return maxProfit;
    }
}
