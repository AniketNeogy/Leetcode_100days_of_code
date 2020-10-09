/* Question 141 :  Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Follow up:
Can you solve it using O(1) (i.e. constant) memory?

 
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).


Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.

 */

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
