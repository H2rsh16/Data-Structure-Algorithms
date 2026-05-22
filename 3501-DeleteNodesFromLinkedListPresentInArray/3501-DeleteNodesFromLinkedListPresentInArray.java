// Last updated: 22/05/2026, 11:19:05
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode temp = dummy;

        while(temp.next != null){
            if(set.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }

        return dummy.next;
    }
}