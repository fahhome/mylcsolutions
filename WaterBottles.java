package leetcode;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int emptyBottles = 0;
        while (numBottles > 0 || emptyBottles >= numExchange) {

            if (numBottles > 0) {
                ans += numBottles;
                emptyBottles += numBottles;
                numBottles = 0;
            } else if (emptyBottles >= numExchange) {
                int div = emptyBottles / numExchange;
                int rem = emptyBottles % numExchange;
                emptyBottles = rem;
                numBottles = div;
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
