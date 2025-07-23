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

    // 1️⃣ 找出所有根到葉節點的路徑
    List<List<Integer>> getAllPaths() {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsPaths(root, path, result);
        return result;
    }

    private void dfsPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.value);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path)); // 到葉節點就存一份副本
        } else {
            dfsPaths(node.left, path, result);
            dfsPaths(node.right, path, result);
        }

        path.remove(path.size() - 1); // 回溯
    }

    // 2️⃣ 判斷是否有根到葉的路徑，其總和為 targetSum
    boolean hasPathSum(int targetSum) {
        return checkPathSum(root, targetSum);
    }

    private boolean checkPathSum(TreeNode node, int remaining) {
        if (node == null) return false;

        // 到葉子節點
        if (node.left == null && node.right == null) {
            return remaining == node.value;
        }

        return checkPathSum(node.left, remaining - node.value) ||
               checkPathSum(node.right, remaining - node.value);
    }

    // 3️⃣ 找出最大總和的根到葉路徑
    int maxPathSum() {
        return maxPathSumHelper(root).sum;
    }

    List<Integer> getMaxSumPath() {
        return maxPathSumHelper(root).path;
    }

    private static class PathResult {
        int sum;
        List<Integer> path;

        PathResult(int sum, List<Integer> path) {
            this.sum = sum;
            this.path = path;
        }
    }

    private PathResult maxPathSumHelper(TreeNode node) {
        if (node == null) return new PathResult(0, new ArrayList<>());

        if (node.left == null && node.right == null) {
            return new PathResult(node.value, new ArrayList<>(List.of(node.value)));
        }

        PathResult left = maxPathSumHelper(node.left);
        PathResult right = maxPathSumHelper(node.right);

        if (left.sum > right.sum) {
            left.path.add(0, node.value);
            return new PathResult(left.sum + node.value, left.path);
        } else {
            right.path.add(0, node.value);
            return new PathResult(right.sum + node.value, right.path);
        }
    }
}
public class TreePathProblems {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // 範例樹：
        //        5
        //       / \
        //      4   8
        //     /   / \
        //    11  13  4
        //   /  \      \
        //  7    2      1
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(4);
        tree.root.right.right.right = new TreeNode(1);

        // 1️⃣ 所有根到葉的路徑
        System.out.println("所有根到葉的路徑：");
        for (List<Integer> path : tree.getAllPaths()) {
            System.out.println(path);
        }

        // 2️⃣ 判斷是否存在和為 22 的根到葉路徑
        int targetSum = 22;
        System.out.println("\n是否有總和為 " + targetSum + " 的路徑: " + tree.hasPathSum(targetSum));

        // 3️⃣ 最大總和的根到葉路徑
        System.out.println("\n最大總和的根到葉路徑總和: " + tree.maxPathSum());
        System.out.println("最大總和路徑: " + tree.getMaxSumPath());
    }
}    

