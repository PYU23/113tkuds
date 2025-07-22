import java.util.Scanner;
public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }
        for (int i = 0; i < n - 1; i++) {//選擇排序法
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }
        int outputCount = Math.min(n, 5);
        for (int i = 0; i < outputCount; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
        sc.close();
    }
}

/*
 * Time Complexity: O(n^2)
 * 外層迴圈執行n-1次，內層從i+1~n搜尋最大值，比較 (n-1)+(n-2)+...+1 = n(n-1)/2 次
 * 總體複雜度O(n^2)，用於n≤1000的情境
 */
    

