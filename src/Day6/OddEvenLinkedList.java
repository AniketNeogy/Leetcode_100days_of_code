/*
 * Question 32 :  Odd Even Linked List

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.



Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Constraints:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].

 */

package Day6;

public class OddEvenLinkedList {

	//O(1) space complexity O(nodes) time complexity
	public ListNode oddEvenList(ListNode head) {
		if(head == null) return null;

		ListNode oddPointer = head;
		ListNode evenPointer = head.next;
		ListNode evenPointerHead = evenPointer;

		while(evenPointer!=null && evenPointer.next!=null){
			oddPointer.next = oddPointer.next.next;
			oddPointer = oddPointer.next;
			evenPointer.next = evenPointer.next.next;
			evenPointer = evenPointer.next;
		}

		oddPointer.next = evenPointerHead;

		return head;
	}

	public static void main(String[] args) {
		ListNode  newNode5 = new ListNode(5,null);
		ListNode  newNode4 = new ListNode(4,newNode5);
		ListNode  newNode3 = new ListNode(3,newNode4);
		ListNode  newNode2 = new ListNode(2,newNode3);
		ListNode  newNode1 = new ListNode(1,newNode2);
		
		ListNode head = newNode1;

		ListNode pointer = head;
		while(pointer != null) {
			System.out.print(pointer.val + " ");
			pointer = pointer.next;
		}

		OddEvenLinkedList list  = new OddEvenLinkedList();
		list.oddEvenList(head);
		
		System.out.println("\n");
		
		pointer = head;
		while(pointer != null) {
			System.out.print(pointer.val + " ");
			pointer = pointer.next;
		}
		

	}

}
