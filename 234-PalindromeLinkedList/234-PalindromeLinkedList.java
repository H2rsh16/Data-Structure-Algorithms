// Last updated: 22/05/2026, 11:24:33
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private static int[] arr = new int[100000];
    public boolean isPalindrome(ListNode head) {
        final int[] array = arr;
        int n = 0;

        while (head != null) {
            arr[n++] = head.val;
            head = head.next;
        }

        int m = n / 2;
        for (int i = 0; i < m; i++) {
            if (arr[i] != arr[n - i - 1]) {
                return false;
            }
        }
        return true;

    }
}