class Solution {
    public int maxProfit(int[] prices) {
        int c = 0;
        int p = 0; 
        int minPrice = prices[0]; 

        for (int j = 0; j < prices.length; j++) {
            if (prices[j] < minPrice) {
                minPrice = prices[j]; 
            }
            int mp = prices[j] - minPrice;
            if (p < mp) {
                p = mp;
                c = p; 
            }
        }
        return c;
    }
}