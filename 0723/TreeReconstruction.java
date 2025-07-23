import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
public class TreeReconstruction {
    private static Map<Integer, Integer> inorderIndexMap;

    // === 根據前序 + 中序 重建 ===
    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);
        return buildPreIn(preorder, 0, preorder.length - 1, 0);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderIndexMap.get(rootVal);
        int leftSize = inIndex - inStart;

        root.left = buildPreIn(preorder, preStart + 1, preStart + leftSize, inStart);
        root.right = buildPreIn(preorder, preStart + leftSize + 1, preEnd, inIndex + 1);

        return root;
    }

    // === 根據後序 + 中序 重建 ===
    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);
        return buildPostIn(postorder, 0, postorder.length - 1, 0);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd, int inStart) {
        if (postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderIndexMap.get(rootVal);
        int leftSize = inIndex - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + leftSize - 1, inStart);
        root.right = buildPostIn(postorder, postStart + leftSize, postEnd - 1, inIndex + 1);

        return root;
    }

    // === 印出中序（作為驗證） ===
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // 測試
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        System.out.println("由前序 + 中序重建後的中序輸出：");
        TreeNode root1 = buildTreePreIn(preorder, inorder);
        printInorder(root1);
        System.out.println();

        System.out.println("由後序 + 中序重建後的中序輸出：");
        TreeNode root2 = buildTreePostIn(postorder, inorder);
        printInorder(root2);
    }
}

