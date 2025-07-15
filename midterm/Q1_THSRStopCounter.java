import java.util.Scanner;
public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stations = {
            "NAN", "TPE", "BAN", "TAO", "HSZ", "MIA",
            "TXG", "CHY", "YUL", "JIJ", "TNN", "ZOS"
        };
        int n = sc.nextInt();
        String[] stopSeq = new String[n];
        for (int i = 0; i < n; i++) {
            stopSeq[i] = sc.next();
        }
        String start = sc.next();
        String end = sc.next();
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stopSeq[i].equals(start)) {
                startIdx = i;
            }
            if (stopSeq[i].equals(end)) {
                endIdx = i;
            }
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(endIdx - startIdx) + 1;
            System.out.println(count);
        
        sc.close();
    }
}
}

/*
 * Time Complexity:O(n)
 * 走訪停靠站陣列一次尋找開始站的位置
 * n為停靠站數量，最多為12
 * 所以總共花費O(n)時間來進行查找與比較
 */
    
    

