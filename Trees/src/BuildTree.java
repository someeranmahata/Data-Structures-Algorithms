import java.util.*;

public class BuildTree {

    public static void main(String[] args) {
        Integer[] arr = {62, 2, 93, null, 30, null, null, 15, null, null, null};
        TreeNode root = buildTree(arr);

        System.out.println(searchBST(root, 15).val);

    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        while(root != null){
            if(root.val == val)
                return root;
            if(val < root.val){
                root = root.left;
            }
            else if(val > root.val){
                root = root.right;
            }

        }
        return null;
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        Integer[] ar = new  Integer[arr.length];
        ar[0] = root.val;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                ar[i] = arr[i];
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                ar[i] = arr[i];
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
//        System.out.println(Arrays.toString(ar));
        return root;
    }

    public static void preorder(TreeNode root) {
        if (root == null){
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");  // print current node

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
