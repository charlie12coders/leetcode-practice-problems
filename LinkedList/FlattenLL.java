package LinkedList;

public class FlattenLL {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node dummy = new Node();
        flattenLL(head,dummy);
        head = dummy.next;
        head.prev = null;
        return head;
    }
    public Node flattenLL(Node cur, Node res){
        Node node = new Node(cur.val);
        node.prev = res;
        res.next = node;
        res = res.next;
        if(cur.child != null) res = flattenLL(cur.child,res);
        if(cur.next != null) res = flattenLL(cur.next,res);
        return res;
    }
}
