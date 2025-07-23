import java.util.*;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int val) {
        value = val;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    // 1. 驗證是否為合法 BST
    boolean isValidBST(TreeNode node) {
        return validate(node, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.value <= min) || (max != null && node.value >= max))
            return false;
        return validate(node.left, min, node.value) &&
               validate(node.right, node.value, max);
    }

    // 2. 找出中序走訪中不符 BST 的節點（應該是遞增）
    List<TreeNode> findInvalidNodes() {
        List<TreeNode> invalid = new ArrayList<>();
        TreeNode[] prev = new TreeNode[1];  // 用 array 模擬引用傳遞
        inOrderFindInvalid(root, prev, invalid);
        return invalid;
    }

    private void inOrderFindInvalid(TreeNode node, TreeNode[] prev, List<TreeNode> invalid) {
        if (node == null) return;
        inOrderFindInvalid(node.left, prev, invalid);
        if (prev[0] != null && node.value <= prev[0].value) {
            invalid.add(node);
        }
        prev[0] = node;
        inOrderFindInvalid(node.right, prev, invalid);
    }

    // 3. 計算需要移除幾個節點才能變成嚴格遞增的 BST（用 LIS）
    int minRemovalsToBST() {
        List<Integer> inorderList = new ArrayList<>();
        collectInorderValues(root, inorderList);

        // 求 LIS 長度
        List<Integer> lis = new ArrayList<>();
        for (int val : inorderList) {
            int idx = Collections.binarySearch(lis, val);
            if (idx < 0) idx = -(idx + 1);
            if (idx == lis.size()) lis.add(val);
            else lis.set(idx, val);
        }

        return inorderList.size() - lis.size(); // 非遞增的就是要移除的
    }

    private void collectInorderValues(TreeNode node, List<Integer> list) {
        if (node == null) return;
        collectInorderValues(node.left, list);
        list.add(node.value);
        collectInorderValues(node.right, list);
    }
}

public class BSTValidation {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // 非合法 BST 範例
        //       10
        //      /  \
        //     5    8   ← 不合法（右子樹小於根）
        //    /
        //   2
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(8);   // 錯誤：應該比 10 大
        tree.root.left.left = new TreeNode(2);

        System.out.println("是否為合法 BST: " + tree.isValidBST(tree.root));

        List<TreeNode> badNodes = tree.findInvalidNodes();
        System.out.print("違規節點: ");
        for (TreeNode n : badNodes) {
            System.out.print(n.value + " ");
        }
        System.out.println();

        int removals = tree.minRemovalsToBST();
        System.out.println("至少需移除節點數量: " + removals);
    }
}

