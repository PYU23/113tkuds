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

    // 1. 取得每層節點的 List（層序走訪）
    List<List<Integer>> levelOrderZigzag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                // 之字形：根據方向決定從前面或後面加
                if (leftToRight) {
                    level.addLast(curr.value);
                } else {
                    level.addFirst(curr.value);
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // 2. 印出每層最後一個節點
    void printLastNodePerLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode lastNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                lastNode = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            System.out.println("本層最後一個節點: " + lastNode.value);
        }
    }
}

public class TreeLevelTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // 範例樹：
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println("== 各層之字形走訪內容 ==");
        List<List<Integer>> zigzagLevels = tree.levelOrderZigzag(tree.root);
        for (int i = 0; i < zigzagLevels.size(); i++) {
            System.out.println("Level " + (i+1) + ": " + zigzagLevels.get(i));
        }

        System.out.println("\n== 每層最後一個節點 ==");
        tree.printLastNodePerLevel(tree.root);
    }
}

}
