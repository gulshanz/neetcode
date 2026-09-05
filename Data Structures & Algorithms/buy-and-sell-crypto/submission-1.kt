class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var boughtPrice = prices[0]

        for(price in prices){
            if(price>boughtPrice){
                profit = max(price - boughtPrice, profit)
            } else {
                boughtPrice = price
            }
        }

        return profit
    }
}
