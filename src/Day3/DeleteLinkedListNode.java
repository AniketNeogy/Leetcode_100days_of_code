/*
 * Question 237. Delete Node in a Linked List

Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.

Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.


Example 2:
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.


Example 3:
Input: head = [1,2,3,4], node = 3
Output: [1,2,4]


Example 4:
Input: head = [0,1], node = 0
Output: [1]

Example 5:
Input: head = [-3,5,-99], node = -3
Output: [5,-99]
 

Constraints:

The number of the nodes in the given list is in the range [2, 1000].
-1000 <= Node.val <= 1000
The value of each node in the list is unique.
The node to be deleted is in the list and is not a tail node
 */



package Day3;


public class DeleteLinkedListNode {
	public void deleteNode(ListNode node) {
		node.val= node.next.val;
		node.next = node.next.next;
	}


	public static void main(String[] args) {

		ListNode  newNode7 = new ListNode(7,null);
		ListNode  newNode6 = new ListNode(6, newNode7);
		ListNode  newNode5 = new ListNode(5, newNode6);
		ListNode  newNode4 = new ListNode(4, newNode5);
		ListNode  newNode3 = new ListNode(3,newNode4);
		ListNode  newNode2 = new ListNode(2,newNode3);
		ListNode  head = new ListNode(1,newNode2);

		DeleteLinkedListNode deleteNodeFromLinkedList  = new DeleteLinkedListNode();
		deleteNodeFromLinkedList.deleteNode(newNode3);

		while (head != null) {
			System.out.print(head.val);
			if(head.next!=null) System.out.print("->");
			head = head.next;

		}


	}

}
