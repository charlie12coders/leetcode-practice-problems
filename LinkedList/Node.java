package LinkedList;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public  Node random;
    
    Node(){}
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
