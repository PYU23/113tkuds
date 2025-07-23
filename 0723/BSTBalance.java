class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class BSTBalance {
    static class BalanceInfo {
        boolean isBalanced;
        int height;
        BalanceInfo(boolean b, int h) {
            isBalanced = b;
            height = h;
        }
    }

    // 1. 檢查是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    private static BalanceInfo checkBalance(TreeNode node) {
        if (node == null) return new BalanceInfo(true, 0);

        BalanceInfo left = checkBalance(node.left);
        BalanceInfo right = checkBalance(node.right);

        boolean balanced = left.isBalanced && right.isBalanced &&
                Math.abs(left.height - right.height) <= 1;

        int height = 1 + Math.max(left.height, right.height);
        return new BalanceInfo(balanced, height);
    }

    // 2. 計算節點的平衡因子 (BF = leftHeight - rightHeight)
    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 3. 找出最不平衡的節點（平衡因子絕對值最大）
    static class UnbalanceNode {
        TreeNode node;
        int bf; // balance factor
        UnbalanceNode(TreeNode n, int b) {
            node = n; bf = b;
        }
    }

    public static UnbalanceNode findMostUnbalancedNode(TreeNode root) {
        return helper(root, new UnbalanceNode(null, 0));
    }

    private static UnbalanceNode helper(TreeNode node, UnbalanceNode maxUnbalance) {
        if (node == null) return maxUnbalance;

        int bf = getBalanceFactor(node);
        if (maxUnbalance.node == null || Math.abs(bf) > Math.abs(maxUnbalance.bf)) {
            maxUnbalance.node = node;
            maxUnbalance.bf = bf;
        }

        maxUnbalance = helper(node.left, maxUnbalance);
        maxUnbalance = helper(node.right, maxUnbalance);
        return maxUnbalance;
    }

    // 測試用中序印樹
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // 建立一棵非平衡 BST 範例
        /*
                10
               /  \
              5    15
             /       \
            2         20
           /
          1
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(20);

        System.out.println("BST 中序:");
        printInorder(root);
        System.out.println();

        System.out.println("是否為平衡樹？ " + isBalanced(root));
        UnbalanceNode unbalanced = findMostUnbalancedNode(root);
        System.out.println("最不平衡節點值: " + unbalanced.node.val + ", 平衡因子: " + unbalanced.bf);
    }
}


