public class hk2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 3, 2, 4, 5};
        System.out.println(isSorted(a, 0)); // true
        System.out.println(isSorted(b, 0)); // false
    }

    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }
}


