import java.util.Scanner;
public class Q2_NextTHSRDeparture {
    static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    static String minutesToTime(int mins) {
        int h = mins / 60;
        int m = mins % 60;
        return String.format("%02d:%02d", h, m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        String[] timeStrs = new String[n];
        for (int i = 0; i < n; i++) {
            timeStrs[i] = sc.nextLine();
            times[i] = timeToMinutes(timeStrs[i]);
        }
        String queryStr = sc.nextLine();
        int query = timeToMinutes(queryStr);
        int left = 0, right = n - 1;
        int idx = n; 
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrs[idx]);
        }
        sc.close();
    }
}

/*
 * Time Complexity: O(log n)
 * 把排序好的班次時間用分鐘轉為int陣列，查詢時用二分搜尋
 * 搜尋範圍每次折半，時間log n
 * 所以總體搜尋時間複雜度為O(log n)
 */
    

