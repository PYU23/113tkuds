public static int digitSum(int n) {
    if (n < 10) {
        return n; // 終止條件：只有一位數時，直接回傳
    }
    return n % 10 + digitSum(n / 10); // 個位數 + 剩下的遞迴結果
}

    

