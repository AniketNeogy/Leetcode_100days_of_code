/* Question 234 :  Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

*/

package Day4;

import java.util.ArrayList;
import java.util.List;

import Day3.DeleteLinkedListNode;

public class PalindromeLinkedList {


	//Complexity is O(n) - However this is not the most optimal solution
	public boolean isPalindrome(ListNode head) {

		ListNode prev = null;

		if(head == null || head.next == null)
			return true;

		List<Integer> mylist = new ArrayList<Integer>();

		while(head!=null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
			mylist.add(prev.val);
		}
		head = prev;

		int i=0;
		while(head!=null){
			if(head.val!=mylist.get(i))
				return false;
			i++;
			head = head.next;
		}
		return true;

	}
	
	
	// Complexity is O(n) - Optimal Solution
	public boolean isPalindrome1(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while(fast!=null && fast.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		slow = reverse(slow);
		fast = head;

		while(slow != null) {
			if(slow.val != fast.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;

	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;

		while(head!=null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}



	public static void main(String[] args) {
		ListNode  newNode8 = new ListNode(1, null);
		ListNode  newNode7 = new ListNode(2, newNode8);
		ListNode  newNode6 = new ListNode(3, newNode7);
		ListNode  newNode5 = new ListNode(4, newNode6);
		ListNode  newNode4 = new ListNode(4, newNode5);
		ListNode  newNode3 = new ListNode(3,newNode4);
		ListNode  newNode2 = new ListNode(2,newNode3);
		ListNode  head = new ListNode(1,newNode2);

		PalindromeLinkedList CheckLinkedListPalindrome  = new PalindromeLinkedList();
		CheckLinkedListPalindrome.isPalindrome1(head);
	}

}
