
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) {
        val = v;
    }
}
public class BSTConversion {
    static class DoublyListNode {
        int val;
        DoublyListNode prev, next;
        DoublyListNode(int v) {
            val = v;
        }
    }

    static DoublyListNode prevNode = null;
    static DoublyListNode headNode = null;

    public static DoublyListNode bstToDoublyLinkedList(TreeNode root) {
        prevNode = null;
        headNode = null;
        inorderConvert(root);
        return headNode;
    }

    private static void inorderConvert(TreeNode root) {
        if (root == null) return;

        inorderConvert(root.left);

        DoublyListNode curr = new DoublyListNode(root.val);
        if (prevNode == null) {
            headNode = curr;
        } else {
            prevNode.next = curr;
            curr.prev = prevNode;
        }
        prevNode = curr;

        inorderConvert(root.right);
    }

    // 功能 2：排序陣列 -> 平衡 BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBalancedBST(nums, left, mid - 1);
        node.right = buildBalancedBST(nums, mid + 1, right);
        return node;
    }

    // 功能 3：BST -> Greater Sum Tree
    static int sum = 0;

    public static void convertToGreaterSumTree(TreeNode root) {
        sum = 0;
        reverseInorder(root);
    }

    private static void reverseInorder(TreeNode root) {
        if (root == null) return;

        reverseInorder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorder(root.left);
    }

    // 顯示 BST（中序）
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // 顯示雙向鏈表
    public static void printDoublyLinkedList(DoublyListNode head) {
        DoublyListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // 測試
    public static void main(String[] args) {
        // 原始 BST：      20
        //               /    \
        //             10      30
        //            /  \    /  \
        //           5   15  25  35

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        System.out.println("功能 1：BST 轉雙向鏈表");
        DoublyListNode dllHead = bstToDoublyLinkedList(root);
        printDoublyLinkedList(dllHead);

        System.out.println("功能 2：排序陣列轉平衡 BST");
        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstFromSorted = sortedArrayToBST(sorted);
        printInOrder(bstFromSorted); // 印出：1 2 3 4 5 6 7
        System.out.println();

        System.out.println("功能 3：轉換為 Greater Sum Tree");
        convertToGreaterSumTree(root);
        printInOrder(root); // 印出轉換後的新值
    }
}