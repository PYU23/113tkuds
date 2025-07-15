import java.util.Scanner;
public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        sc.nextLine(); 
        String[] station = new String[n];
        int[][] price = new int[n][2]; // price[i][0]=Standard, price[i][1]=Business
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            station[i] = parts[0];
            price[i][0] = Integer.parseInt(parts[1]);
            price[i][1] = Integer.parseInt(parts[2]);
        }
        System.out.printf("%-8s|%-9s|%-8s\n", "Station", "Standard", "Business");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8s|%-9d|%-8d\n", station[i], price[i][0], price[i][1]);
        }
        sc.close();
    }
}
    

