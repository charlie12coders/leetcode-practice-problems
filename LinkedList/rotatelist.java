package LinkedList;

public class rotatelist {
    public ListNode rotateRight(ListNode head, int k) {
        // If the linked list is empty (head == null) or k is zero,
        // the list remains unchanged, so the function returns the head as is.
        if(head==null || k==0){
            return head;
        }
        //This loop traverses the list to find its length (count).
        // It also moves temp to the last node of the list.
        ListNode temp = head;
        int count = 1;
        while(temp.next!=null){
            temp=temp.next;
            count++;
        }
        // The first line ensures that k is within the bounds of
        // the list length by taking k modulo count.
        k %= count;
        // The second line converts the right rotation into an equivalent left rotation.
        // For example, rotating right by 2 places
        // in a list of length 5 is the same as rotating left by 3 places.
        k=count-k;
        //This loop performs the left rotation k times:
        //temp.next = head; connects the last node to the current head,
        // making the list circular temporarily.
        //head = head.next; moves the head to the next node.
        //temp = temp.next; moves temp to the new last node.
        //temp.next = null; breaks the circular connection,
        // restoring the list to a linear form.
        //k--; decrements k until the rotation is complete.
        while(k>0){
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = null;
            k--;
        }
        //Finally, the function returns the new head of the rotated list.
        return head;
    }
}
