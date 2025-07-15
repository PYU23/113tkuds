import java.util.Scanner;
public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 賽季場次
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = sc.nextInt(); // 1 表勝，0 表敗
        }
        int k = sc.nextInt(); // 查詢前 k 場勝場累計
        int[] prefix = new int[n + 1]; // prefix[i] 表示前 i 場的勝場數
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + results[i - 1];
        }
        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + prefix[i]);
        }
        System.out.println();
        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 建立prefix陣列時run原始資料，共需O(n)時間
 * 輸出前k項prefix也是O(k)，k≤n
 * 因此整體複雜度為O(n)
 */
    

