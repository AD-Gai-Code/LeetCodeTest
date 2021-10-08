package leetcodeTest.listNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest234 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        int n = arr.length;
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkedList(arr,n);
        boolean b = isPalindrome2(head);
        System.out.println(b);
        //listNode.printLinkedList(head);
    }

    public static boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            if(list.get(left).val == list.get(right).val){
                left ++;
                right --;
            } else if(list.get(left) != list.get(right)){
                return false;
            }
            if(left >= right){
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode mid = getMid(head);
        System.out.println(mid.val);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        boolean b = isPalin(l1,l2);
        return b;
    }

    private static ListNode reverse(ListNode l2) {
        ListNode prev = null;
        ListNode curr = l2;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static boolean isPalin(ListNode l1,ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if(cur1.val == cur2.val){
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if(cur1.val != cur2.val){
                return false;
            }
        }
        return true;
    }

    private static ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
