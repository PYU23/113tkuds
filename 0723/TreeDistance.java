import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class TreeDistance {
    TreeNode root;

    // 1. 計算兩個節點距離（以值尋找節點）
    public int distanceBetweenNodes(int val1, int val2) {
        TreeNode lca = lowestCommonAncestor(root, val1, val2);
        if (lca == null) return -1;
        int dist1 = distanceFromNode(lca, val1, 0);
        int dist2 = distanceFromNode(lca, val2, 0);
        if (dist1 == -1 || dist2 == -1) return -1;
        return dist1 + dist2;
    }

    // 找最近公共祖先 LCA
    private TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        if (node == null) return null;
        if (node.val == p || node.val == q) return node;

        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        if (left != null && right != null) return node;
        return left != null ? left : right;
    }

    // 從 node 開始找目標節點 val 的距離，找不到回 -1
    private int distanceFromNode(TreeNode node, int val, int dist) {
        if (node == null) return -1;
        if (node.val == val) return dist;

        int leftDist = distanceFromNode(node.left, val, dist + 1);
        if (leftDist != -1) return leftDist;

        return distanceFromNode(node.right, val, dist + 1);
    }

    // 2. 找樹的直徑（任意兩點間最大距離）
    private int diameter = 0;

    public int treeDiameter() {
        diameter = 0;
        height(root);
        return diameter;
    }

    // 回傳節點高度，過程中更新直徑
    private int height(TreeNode node) {
        if (node == null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);

        diameter = Math.max(diameter, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }

    // 3. 找距離根節點 k 距離的所有節點
    public List<Integer> nodesAtDistanceK(int k) {
        List<Integer> result = new ArrayList<>();
        nodesAtDistanceKHelper(root, k, result);
        return result;
    }

    private void nodesAtDistanceKHelper(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.val);
            return;
        }
        nodesAtDistanceKHelper(node.left, k - 1, result);
        nodesAtDistanceKHelper(node.right, k - 1, result);
    }

    // 測試用中序印樹
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // 主程式測試
    public static void main(String[] args) {
        TreeDistance tree = new TreeDistance();

        // 範例樹：
        //         1
        //        / \
        //       2   3
        //      / \    
        //     4   5  
        //          \
        //           6

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.right = new TreeNode(6);

        System.out.println("中序遍歷：");
        printInorder(tree.root);
        System.out.println();

        System.out.println("節點 4 與 6 之距離：" + tree.distanceBetweenNodes(4, 6));
        System.out.println("樹的直徑：" + tree.treeDiameter());
        int k = 2;
        System.out.println("距離根節點 " + k + " 的所有節點：" + tree.nodesAtDistanceK(k));
    }
}

