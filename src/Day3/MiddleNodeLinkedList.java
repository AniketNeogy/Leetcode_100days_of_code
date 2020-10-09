/*
 * Question 876 -  Middle of the Linked List

 Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.


Note:

The number of nodes in the given list will be between 1 and 100.


 */

package Day3;


public class MiddleNodeLinkedList {

	//Complexity = O(n) -- Optimal Solution
	public ListNode middleNode(ListNode head) {
		ListNode current = head;
		int listSize = 0;
		int counter = 0;
		int nodeindex = 0;
		while(current!=null){
			listSize++;
			current = current.next; 
		}

		if(listSize%2!=0){
			counter = 1;
			current = head;
			nodeindex = listSize/2 + listSize%2;
			while(counter!= nodeindex){
				current = current.next;
				counter++;
			}
			return current;
		}

		if(listSize%2==0){
			counter = 1;
			current = head;
			nodeindex = listSize/2+1;
			while(counter!= nodeindex){
				current = current.next;
				counter++;
			}
			return current;
		}

		return null;
	}

	
	//Complexity = O(n) -- This is also an Optimal Solution  - logic wise its cleaner
	public ListNode middleNode1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast!=null && fast.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}




	public static void main(String[] args) {

		ListNode  newNode6 = new ListNode(6, null);
		ListNode  newNode5 = new ListNode(5, newNode6);
		ListNode  newNode4 = new ListNode(4, newNode5);
		ListNode  newNode3 = new ListNode(3,newNode4);
		ListNode  newNode2 = new ListNode(2,newNode3);
		ListNode  head = new ListNode(1,newNode2);

		MiddleNodeLinkedList findMiddleOfLinkedList  = new MiddleNodeLinkedList();
		ListNode middleNode = findMiddleOfLinkedList.middleNode(head);

		while (middleNode != null) {
			System.out.print(middleNode.val);
			if(middleNode.next!=null) System.out.print("->");
			middleNode = middleNode.next;

		}

	}

}
