import java.util.Scanner;
public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        sc.nextLine();  
        int[] times = new int[n]; 
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            times[i] = hour * 60 + minute;
        }
        String[] queryParts = sc.nextLine().split(":");
        int queryHour = Integer.parseInt(queryParts[0]);
        int queryMinute = Integer.parseInt(queryParts[1]);
        int queryTime = queryHour * 60 + queryMinute;
        int left = 0, right = n - 1;
        int answerIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryTime) {
                answerIndex = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (answerIndex == -1) {
            System.out.println("No bike");
        } else {
            int ansTime = times[answerIndex];
            int ansHour = ansTime / 60;
            int ansMinute = ansTime % 60;
            System.out.printf("%02d:%02d\n", ansHour, ansMinute);
        }
        sc.close();
    }
}
/*
 * Time Complexity:O(log n)
 * 程式對已排序的 n 筆抵達時間資料進行二分搜尋，尋找第一個大於查詢時間的時刻，
 * 二分搜尋的時間複雜度為 O(log n)。其餘操作如輸入讀取與字串轉換皆為 O(n) 與 O(1)，
 * 但主要查詢操作為 O(log n)，因此整體時間複雜度為 O(log n)。
 */
