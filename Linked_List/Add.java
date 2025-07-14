import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Add {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode result = null;
        int carry = 0;

        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            int digit1 = !stack1.empty() ? stack1.pop() : 0;
            int digit2 = !stack2.empty() ? stack2.pop() : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            newNode.next = result;
            result = newNode;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ar = {3,9,9,9,9,9,9,9,9,9};
        int[] ar2 = {7};
        ListNode l1 = new ListNode(ar[0]);
        ListNode l2 = new ListNode(ar2[0]);
        l1 =populate(l1, ar);
        l2 = populate(l2, ar2);
        addTwoNumbers(l1, l2);

    }
    public static ListNode populate(ListNode node, int[] ar){
        ListNode temp = node;
        for(int i = 1; i < ar.length; i++){
            temp.next = new ListNode(ar[i]);
            temp = temp.next;
        }
        return node;
    }
}
