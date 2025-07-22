public static void printReverse(ListNode head) {
    if (head == null) {
        return; // 終止條件：走到底
    }
    printReverse(head.next);       // 先遞迴到底
    System.out.print(head.val + " "); // 然後從尾端往回印
}

    

