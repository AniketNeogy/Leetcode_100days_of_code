/*
 * Question 206 : Reverse Linked List
 
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

 */



package Day2;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	
}

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if(head.next == null)
			return head;
		
		ListNode prev = null;
		
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;

	}
	public static void main(String[] args) {
		
		ListNode  newNode5 = new ListNode(5,null);
		ListNode  newNode4 = new ListNode(4, newNode5);
		ListNode  newNode3 = new ListNode(3,newNode4);
		ListNode  newNode2 = new ListNode(2,newNode3);
		ListNode  head = new ListNode(1,newNode2);
		
		ReverseLinkedList revLinkedList  = new ReverseLinkedList();
		ListNode newHead = revLinkedList.reverseList(head);
		

	}

}
