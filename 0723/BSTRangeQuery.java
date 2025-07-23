import java.util.ArrayList;
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

    // 插入新節點
    void insert(int val) {
        root = insertRec(root, val);
    }

    TreeNode insertRec(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.value) node.left = insertRec(node.left, val);
        else if (val > node.value) node.right = insertRec(node.right, val);
        return node;
    }

    // 範圍查詢
    ArrayList<Integer> rangeQuery(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        rangeQuery(root, min, max, result);
        return result;
    }

    void rangeQuery(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        if (node.value > min) {
            rangeQuery(node.left, min, max, result);
        }

        if (node.value >= min && node.value <= max) {
            result.add(node.value);
        }

        if (node.value < max) {
            rangeQuery(node.right, min, max, result);
        }
    }
}
public class BSTRangeQuery {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {20, 10, 30, 5, 15, 25, 35};

        for (int val : values) {
            tree.insert(val);
        }

        int min = 12;
        int max = 27;
        ArrayList<Integer> result = tree.rangeQuery(min, max);

        System.out.println("範圍 [" + min + ", " + max + "] 內的節點值: " + result);
    }
}

    

