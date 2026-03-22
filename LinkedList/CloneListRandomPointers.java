package LinkedList;
import java.util.*;

// ### 1. The Strategy: "The Mapping Strategy"
// "I'm using a **HashMap** to create a 1-to-1 mapping 
// between the original nodes and their copies. This is necessary because the
//  `random` pointers can point to nodes that haven't been created yet 
// if we try to do it in a single pass. The Map acts as a 'lookup table'
//  so we can link any node to any other node regardless of where they appear in the list."

// ---

// ### 2. The Execution: "The Two-Pass Approach"
// "I break the problem into two distinct phases:"

// * **Pass 1 (Creation):** "I iterate through the original list and create a 
// 'clone' for every node. At this stage, I only copy the `val`. 
// I store the original node as the **Key** and the clone as the **Value** 
// in my HashMap. By the end of this pass, all nodes exist in memory,
//  but they aren't connected yet."
// * **Pass 2 (Linking):** "I iterate through the original list a second time. 
// For each node, I look up its clone in the map. I then set the clone’s `next` 
// and `random` pointers by fetching the corresponding clones from the map. 
// Using `map.get()` handles the `null` cases naturally."

// ---

public class CloneListRandomPointers {
    public Node copyRandomList(Node head) {
        Map<Node,Node> my_map=new HashMap<>();
        Node curr=head;
        while (curr!=null) {
            my_map.put(curr, new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while (curr!=null) {
            Node copy=my_map.get(curr);
            copy.next=my_map.get(curr.next);
            copy.random=my_map.get(curr.random);
            curr=curr.next;
        }
        return my_map.get(head);
    }
}
