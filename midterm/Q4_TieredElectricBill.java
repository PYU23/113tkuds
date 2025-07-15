import java.util.Scanner;
public class Q4_TieredElectricBill {
    static double calc(int kWh) {
        double fee = 0;
        int remaining = kWh;
        if (remaining > 1000) {
            fee += (remaining - 1000) * 8.46;
            remaining = 1000;
        }
        if (remaining > 700) {
            fee += (remaining - 700) * 6.24;
            remaining = 700;
        }
        if (remaining > 500) {
            fee += (remaining - 500) * 5.04;
            remaining = 500;
        }
        if (remaining > 330) {
            fee += (remaining - 330) * 3.70;
            remaining = 330;
        }
        if (remaining > 120) {
            fee += (remaining - 120) * 2.45;
            remaining = 120;
        }
        if (remaining > 0) {
            fee += remaining * 1.68;
        }

        return fee;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] usage = new int[n];
        double[] bills = new double[n];
        double total = 0;
        for (int i = 0; i < n; i++) {
            usage[i] = sc.nextInt();
            bills[i] = calc(usage[i]);
            total += bills[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("Bill: $%d\n", Math.round(bills[i]));
        }
        System.out.printf("Total: $%d\n", Math.round(total));
        System.out.printf("Average: $%d\n", Math.round(total / n));
        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * calc(int k)固定最多6段費率，時間為O(1)
 * 主程式對每筆資料呼叫一次calc，總共進行n次計算與輸出
 * 整體時間複雜度為O(n)
 */
    

