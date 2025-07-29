import java.util.Scanner;
public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        long[] incomes = new long[n];  

        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextLong();  
        }
        long totalTax = 0;
        for (int i = 0; i < n; i++) {
            long income = incomes[i];
            long tax = calculateTax(income);  
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }
        long averageTax = totalTax / n;
        System.out.println("Average: $" + averageTax);
        sc.close();
    }
    static long calculateTax(long income) {
        long tax = 0;
        long[] thresholds = {560000, 1260000, 2520000, 4720000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        long previous = 0;
        for (int i = 0; i < thresholds.length; i++) {
            if (income > thresholds[i]) {
                tax += (thresholds[i] - previous) * rates[i];
                previous = thresholds[i];
            } else {
                tax += (income - previous) * rates[i];
                return tax;
            }
        }
        tax += (income - thresholds[thresholds.length - 1]) * rates[rates.length - 1];
        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 程式需要走訪 n 筆收入資料，對每筆收入進行稅額計算，
 * 計算稅額時只需依據固定級距一次線性掃描 (最多 5 次比較與加減乘法)，
 * 因此每筆收入的稅額計算為 O(1)，總體時間複雜度為 O(n)。
 */

