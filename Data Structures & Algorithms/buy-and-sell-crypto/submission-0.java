class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int boughtPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>boughtPrice){
                max = Math.max(max, prices[i]-boughtPrice);
            }else{
                boughtPrice = prices[i];
            }
        }
        return max;
    }
}
