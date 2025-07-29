import java.util.Scanner;
public class F06_ArraySecondLargest {
    static class Pair {
        int max;
        int second;
        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  
        }
        Pair result = findSecondLargest(arr, 0, n - 1); 
        System.out.println("SecondMax: " + result.second);
        sc.close();
    }
    static Pair findSecondLargest(int[] arr, int left, int right) {
        if (right - left == 1) {
            int max = Math.max(arr[left], arr[right]);
            int second = Math.min(arr[left], arr[right]);
            return new Pair(max, second);
        }
        int mid = (left + right) / 2;
        Pair leftPair = findSecondLargest(arr, left, mid);
        Pair rightPair = findSecondLargest(arr, mid + 1, right);
        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        }
        return new Pair(max, second);
    }
}

/*
 * Time Complexity: O(n)
 * 程式透過 divide-and-conquer (分治法) 方式遞迴找第二大值，
 * 每次遞迴將陣列對半切割，總共有 O(log n) 層遞迴，但每個元素只會被比較一次，
 * 因此總運算次數為 O(n)。合併過程每層操作皆為 O(1)，因此整體時間複雜度為 O(n)。
 */

