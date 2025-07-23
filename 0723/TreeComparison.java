
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) {
        val = v;
    }
}
public class TreeComparison {
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    // 2. 判斷 t 是否是 s 的子樹
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 3. 找最大公共子樹大小（節點數）
    // 回傳子樹大小的輔助結果類別
    static class Result {
        int size;
        boolean isSame;
        Result(int s, boolean same) {
            size = s; isSame = same;
        }
    }

    public static int largestCommonSubtree(TreeNode a, TreeNode b) {
        return helper(a, b).size;
    }

    private static Result helper(TreeNode a, TreeNode b) {
        if (a == null && b == null) return new Result(0, true);
        if (a == null || b == null) return new Result(0, false);

        Result leftRes = helper(a.left, b.left);
        Result rightRes = helper(a.right, b.right);

        boolean currentSame = leftRes.isSame && rightRes.isSame && (a.val == b.val);

        int currentSize = currentSame ? leftRes.size + rightRes.size + 1 : 0;

        return new Result(currentSize, currentSame);
    }

    // 簡易中序列印
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // 主程式測試
    public static void main(String[] args) {
        // 建立樹 A
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        // 建立樹 B (子樹)
        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(4);
        b.right = new TreeNode(5);

        System.out.println("是否完全相同: " + isSameTree(a, b)); // false
        System.out.println("b 是否是 a 的子樹: " + isSubtree(a, b)); // true
        System.out.println("最大公共子樹大小: " + largestCommonSubtree(a, b)); // 3
    }
}

