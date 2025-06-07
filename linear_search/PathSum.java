import java.util.*;
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
public class PathSum {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ar = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve2(root, ar, temp, targetSum);
        return ar;

    }
    //Not working for tree with node value negative
    public static void solve(List<List<Integer>> ans, List<Integer> temp, TreeNode root,int target, int current){

        if(target == current){
            ans.add(new ArrayList(temp));
            return;
        }
        if(root == null)
            return;
        int value = root.val;
        if(target >= value){
            temp.add(value);

            if(root.right == null && root.left == null)
            {
                solve(ans, temp, root.right, target, current + value);
            }
            else{
                solve(ans, temp, root.right, target, current + value);
                solve(ans, temp, root.left, target, current + value);
            }
            temp.remove(temp.size() - 1);
        }

    }
    public static void solve2(TreeNode head, List<List<Integer>> ans, List<Integer> ele, int target){
        if(head == null){
            check(ans, ele, target);
        }
        if(head.right == null && head.left == null){
            ele.add(head.val);
            check(ans, ele, target);
            ele.remove(ele.size() - 1);
        }
        if(head.right != null){
            ele.add(head.val);
            solve2(head.right, ans, ele, target);
            ele.remove(ele.size() - 1);
        }
        if(head.left != null){
            ele.add(head.val);
            solve2(head.left, ans, ele, target);
            ele.remove(ele.size() - 1);
        }
    }
    public static void check(List<List<Integer>> ans, List<Integer> ele, int target){
        int count = 0;
        for(int i = 0; i < ele.size(); i++){
            count += ele.get(i);
        }
        if(count == target)
            ans.add(new ArrayList(ele));
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(3);
        head.left = new TreeNode(2);
        System.out.println(pathSum(head, 3));
        System.out.println();

    }
}