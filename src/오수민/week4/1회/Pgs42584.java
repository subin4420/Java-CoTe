package Stack;

public class Prgm42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] time = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int v = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                time[i]++;
                if (prices[j] < v) {
                    break;
                }
            }
        }
    }
}
