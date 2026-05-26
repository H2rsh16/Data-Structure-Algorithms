// Last updated: 26/05/2026, 12:07:13
1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public boolean hasCycle(ListNode head) {
14        ListNode slow = head;
15        ListNode fast = head;
16
17        if(head == null) return false;
18
19        while(fast != null && fast.next != null){
20            slow = slow.next;
21            fast = fast.next.next;
22
23            if(slow == fast) return true;
24        }
25
26        return false;
27    }
28}