import java.util.Scanner;
public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        String[] stops = new String[n];  
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();  
        }
        String start = sc.next();  
        String end = sc.next();    

        int indexStart = -1;  
        int indexEnd = -1;    
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                indexStart = i;
            }
            if (stops[i].equals(end)) {
                indexEnd = i;
            }
        }
        if (indexStart == -1 || indexEnd == -1) {
            System.out.println("Invalid");
        } else {
            int stopCount = Math.abs(indexStart - indexEnd) + 1;
            System.out.println(stopCount);
        }

        sc.close();
    }
}

/*
 * Time Complexity:O(n)
 * 程式會對長度為n的停靠站序列進行一次線性掃描來尋找起站與終站的位置，
 * 掃描過程中每個站點最多比較兩次 (起站與終站)，因此總運算次數與 n 成正比，
 * 其他動作如輸入、輸出皆為 O(1) 常數時間操作。因此整體時間複雜度為 O(n)。
 */

