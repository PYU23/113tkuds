import java.util.Scanner;
public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        sc.nextLine(); 
        String[] names = new String[n]; 
        int[] qtys = new int[n];     
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();    
            qtys[i] = sc.nextInt();  
        }
        for (int i = 1; i < n; i++) {
            String tempName = names[i];
            int tempQty = qtys[i];
            int j = i - 1;
            while (j >= 0 && qtys[j] < tempQty) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            names[j + 1] = tempName;
            qtys[j + 1] = tempQty;
        }
        int outputCount = Math.min(10, n);
        for (int i = 0; i < outputCount; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
        sc.close();
    }
}
/*
 * Time Complexity: O(n^2)
 * 此程式使用插入排序 (Insertion Sort) 將 n 筆商品銷量由高到低排序，
 * 最壞情況下排序過程需要 O(n^2) 次比較與移動，輸入與輸出部分皆為 O(n)，
 * 但排序操作佔主要時間，因此整體時間複雜度為 O(n^2)。
 */
