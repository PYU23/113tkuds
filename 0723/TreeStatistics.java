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

    // 建構子
    BinaryTree() {
        root = null;
    }

    // 計算節點總和
    int sum(TreeNode node) {
        if (node == null) return 0;
        return node.value + sum(node.left) + sum(node.right);
    }

    // 找最大值
    int findMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);
        return Math.max(node.value, Math.max(leftMax, rightMax));
    }

    // 找最小值
    int findMin(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);
        return Math.min(node.value, Math.min(leftMin, rightMin));
    }

    // 計算葉節點數量
    int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // 計算樹的高度
    int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 提供包裝方法方便 main 呼叫
    int getSum() { return sum(root); }
    int getMax() { return findMax(root); }
    int getMin() { return findMin(root); }
    int getLeafCount() { return countLeaves(root); }
  
public class TreeStatistics {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(20);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(7);
        tree.root.right.right = new TreeNode(25);

        System.out.println("節點總和: " + tree.getSum());
        System.out.println("最大值: " + tree.getMax());
        System.out.println("最小值: " + tree.getMin());
        System.out.println("葉節點數量: " + tree.getLeafCount());
        System.out.println("樹的高度: " + tree.getHeight());
    }
}
    
}
