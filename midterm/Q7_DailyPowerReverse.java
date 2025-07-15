import java.util.Scanner;
public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] usage = new int[7];
        for (int i = 0; i < 7; i++) {
            usage[i] = sc.nextInt();
        }
        int left = 0, right = 6;
        while (left < right) {
            int temp = usage[left];
            usage[left] = usage[right];
            usage[right] = temp;
            left++;
            right--;
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(usage[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
    
