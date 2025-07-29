import java.util.*;
public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        int T = sc.nextInt();
        sc.close();
        TreeNode root = buildTree(nodes);
        int closest = findClosestValue(root, T);
        System.out.println(closest);
    }
    static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();
            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
    static int findClosestValue(TreeNode root, int T) {
        int closest = root.val;
        TreeNode node = root;
        while (node != null) {
            int currVal = node.val;
            int currDiff = Math.abs(currVal - T);
            int closestDiff = Math.abs(closest - T);
            if (currDiff < closestDiff || (currDiff == closestDiff && currVal < closest)) {
                closest = currVal;
            }
            if (T < currVal) {
                node = node.left;
            } else if (T > currVal) {
                node = node.right;
            } else {
                return currVal;
            }
        }
        return closest;
    }
}

