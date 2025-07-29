import java.util.Scanner;
public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();  
        int b = sc.nextInt();  
        int gcdValue = gcd(a, b);  
        int lcmValue = a * b / gcdValue;  
        System.out.println("LCM: " + lcmValue);
        sc.close();
    }
    static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }
}
/*
 * Time Complexity: O(max(a, b))
 * 使用輾轉相減法遞迴求 GCD，每次遞迴將較大數減去較小數，
 * 最壞情況下 (如 a=1, b=N) 需要 O(N) 次遞迴，因此時間複雜度為 O(max(a, b))。
 * LCM 的乘除法為 O(1)，故整體時間複雜度仍為 O(max(a, b))。
 */
