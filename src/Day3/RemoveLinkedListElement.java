/*
 * Question 203. Remove Linked List Elements
 * 
Remove all elements from a linked list of integers that have value val.

Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */



package Day3;

public class RemoveLinkedListElement {
	public ListNode removeElements(ListNode head, int val) {
		while(head!=null && head.val==val)
			head = head.next;

		ListNode current_node = head;
		while(current_node !=null && current_node.next!=null) {
			if(current_node.next.val == val) {
				current_node.next = current_node.next.next;
			}
			else
				current_node = current_node.next;
		}


		return head;

	}


	public static void main(String[] args) {

		ListNode  newNode7 = new ListNode(6,null);
		ListNode  newNode6 = new ListNode(5, newNode7);
		ListNode  newNode5 = new ListNode(4, newNode6);
		ListNode  newNode4 = new ListNode(3, newNode5);
		ListNode  newNode3 = new ListNode(6,newNode4);
		ListNode  newNode2 = new ListNode(2,newNode3);
		ListNode  head = new ListNode(1,newNode2);
		//ListNode  head = new ListNode(1,null);
		
		// 1-> 2 -> 6 -> 3 -> 4 -> 5 -> 6

		RemoveLinkedListElement removeLinkedList  = new RemoveLinkedListElement();
		ListNode newHead = removeLinkedList.removeElements(head, 6);

		while (newHead != null) {
			System.out.print(newHead.val);
			if(newHead.next!=null) System.out.print("->");
			newHead = newHead.next;

		}


	}

}
