package Day4;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


	// Complexity is O(n) -  but its still not the most optimal solution
	public boolean hasCycle(ListNode head) {
		Set<ListNode> nodeSet =  new HashSet<ListNode>();

		if(head == null || head.next == null) return false;

		while(head!=null){
			if(nodeSet.contains(head)){
				return true;
			}
			else{
				nodeSet.add(head);
			}
			head = head.next;
		}
		return false;

	}

	public boolean hasCycle1(ListNode head) {
		if(head == null) return false;

		ListNode slow = head;
		ListNode fast = head.next;

		while(slow != fast){
			if(fast == null || fast.next == null) return false;
			else {
				slow= slow.next;
				fast = fast.next.next;
			}

		}
		return true;

	}



	public static void main(String[] args) {
		ListNode  newNode4 = new ListNode(4);
		ListNode  newNode3 = new ListNode(0);
		ListNode  newNode2 = new ListNode(2);
		ListNode  newNode1 = new ListNode(3);

		ListNode head = newNode1;
		newNode1.next = newNode2;
		newNode2.next = newNode3;
		newNode3.next = newNode4;
		newNode4.next = newNode2;

		LinkedListCycle linkedListCycle  = new LinkedListCycle();
		linkedListCycle.hasCycle(head);

	}

}
