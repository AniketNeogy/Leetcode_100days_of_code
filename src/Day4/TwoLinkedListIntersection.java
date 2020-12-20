/* Question 160 :  Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3

Output: Reference of the node with value = 8

Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. 
There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */


package Day4;

public class TwoLinkedListIntersection {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;

		ListNode a_pointer = headA;
		ListNode b_pointer = headB;

		while(a_pointer != b_pointer){
			
			/*here the reason for iterating to null is that, in case there is no intersection the 
			 * exit condition is reached when both a_pointer null & b_pointer = null
			 */
			if(a_pointer == null){
				a_pointer = headB;
			}else{
				a_pointer = a_pointer.next;
			}

			if(b_pointer == null){
				b_pointer = headA;
			}else{
				b_pointer = b_pointer.next;
			}

		}

		return a_pointer;

	}

	public static void main(String[] args) {
		//Linked List 1
		ListNode  anewNode4 = new ListNode(9,null);
		ListNode  anewNode3 = new ListNode(6,anewNode4);
		ListNode  anewNode2 = new ListNode(4,anewNode3);
		ListNode  head1 = new ListNode(2,anewNode2);

		//Linked List 2
		ListNode  bnewNode2 = new ListNode(5,null);
		ListNode  head2 = new ListNode(1,bnewNode2);

		TwoLinkedListIntersection intersect  = new TwoLinkedListIntersection();
		ListNode intersectedNode = intersect.getIntersectionNode(head1,head2);
		System.out.println("The intersected Node is : "+intersectedNode.val);

	}

}
