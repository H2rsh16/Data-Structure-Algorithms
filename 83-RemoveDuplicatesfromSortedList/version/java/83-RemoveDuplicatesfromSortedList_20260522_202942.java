// Last updated: 22/05/2026, 20:29:42
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode deleteDuplicates(ListNode head) {
13        ListNode dummy = head;
14
15        while(dummy != null && dummy.next != null){
16            if(dummy.val == dummy.next.val){
17                dummy.next = dummy.next.next;
18            }
19            else{
20                dummy = dummy.next;
21            }
22        }
23
24        return head;
25    }
26}