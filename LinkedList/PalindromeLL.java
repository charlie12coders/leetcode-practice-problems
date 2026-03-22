package LinkedList;
public class PalindromeLL{
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode node=null;
        while (slow!=null) {
            ListNode temp=slow.next;
            slow.next=node;
            node=slow;
            slow=temp;
        }
        ListNode first=head,second=node;
        while (second!=null) {
            if (first.val!=second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
}