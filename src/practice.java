
public class practice {

	public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++)
            K[i][0] = 0;
        for (int w = 0; w <= W; w++)
            K[0][w] = 0;

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] > w) {
                    K[i][w] = K[i - 1][w];
                } else {
                    K[i][w] = max(K[i - 1][w], (K[i - 1][w - wt[i - 1]] + val[i - 1]));
                }
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
        int[] val = { 1, 7, 20, 24, 15, 2, 22 };
        int[] wt = { 10, 15, 20, 25, 30, 35, 40 };
        int W = 100;
        int n = val.length;

        System.out.println("Maximum value of the goods in the Knapsack: " + knapSack(W, wt, val, n));
    }
}