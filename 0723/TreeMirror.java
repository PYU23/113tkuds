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

    // 1. 判斷是否為對稱樹
    boolean isSymmetric() {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.value == b.value) &&
               isMirror(a.left, b.right) &&
               isMirror(a.right, b.left);
    }

    // 2. 將樹轉換為鏡像（原地修改）
    void mirror() {
        mirror(root);
    }

    private void mirror(TreeNode node) {
        if (node == null) return;
        // 交換左右子樹
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // 遞迴處理左右子樹
        mirror(node.left);
        mirror(node.right);
    }

    // 3. 比較兩棵樹是否互為鏡像
    static boolean areMirrors(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.value == b.value) &&
               areMirrors(a.left, b.right) &&
               areMirrors(a.right, b.left);
    }

    // 中序列印（驗證用）
    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }
}
public class TreeMirror {
    public static void main(String[] args) {
        // 建立一棵對稱樹
        BinaryTree tree1 = new BinaryTree();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(2);
        tree1.root.left.left = new TreeNode(3);
        tree1.root.left.right = new TreeNode(4);
        tree1.root.right.left = new TreeNode(4);
        tree1.root.right.right = new TreeNode(3);

        System.out.println("是否為對稱樹: " + tree1.isSymmetric());

        // 建立另一棵與 tree1 為鏡像的樹
        BinaryTree tree2 = new BinaryTree();
        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(2);
        tree2.root.left.left = new TreeNode(4);
        tree2.root.left.right = new TreeNode(3);
        tree2.root.right.left = new TreeNode(3);
        tree2.root.right.right = new TreeNode(4);

        System.out.println("tree1 與 tree2 是否為鏡像: " + BinaryTree.areMirrors(tree1.root, tree2.root));

        // 印出原本的中序
        System.out.print("tree1 原始中序遍歷: ");
        tree1.inorder(tree1.root);
        System.out.println();

        // 鏡像 tree1
        tree1.mirror();

        System.out.print("tree1 鏡像後中序遍歷: ");
        tree1.inorder(tree1.root);
        System.out.println();
    }
}
    

