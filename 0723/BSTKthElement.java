class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int val) {
        value = val;
        left = right = null;
    }
}

class BST {
    TreeNode root;

    // 插入節點
    void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.value) node.left = insertRec(node.left, val);
        else if (val > node.value) node.right = insertRec(node.right, val);
        return node;
    }

    // 找出第 k 小的元素（中序走訪計數）
    int findKthSmallest(int k) {
        return kthSmallestHelper(root, new int[]{k});
    }

    private int kthSmallestHelper(TreeNode node, int[] k) {
        if (node == null) return -1;

        // 遞迴左子樹
        int left = kthSmallestHelper(node.left, k);
        if (k[0] == 0) return left;

        // 中間節點
        k[0]--;
        if (k[0] == 0) return node.value;

        // 遞迴右子樹
        return kthSmallestHelper(node.right, k);
    }
}
public class BSTKthElement {
     public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int v : values) {
            tree.insert(v);
        }

        for (int k = 1; k <= 7; k++) {
            int result = tree.findKthSmallest(k);
            System.out.println("第 " + k + " 小的元素是: " + result);
        }
    }
}
    

