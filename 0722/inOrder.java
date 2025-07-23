public static void inOrder(TreeNode root) {
    if (root == null) {
        return; // 遞迴終止條件
    }

    inOrder(root.left);         // 走訪左子樹
    System.out.print(root.val + " "); // 拜訪根節點
    inOrder(root.right);        // 走訪右子樹
}


