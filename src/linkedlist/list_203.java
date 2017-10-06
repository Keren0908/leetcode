package linkedlist;

public class list_203 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}
	
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode prob=head;
		for(int i=2;i<6;i++) {
			prob.next=new ListNode(i);
			prob=prob.next;
			
		}
		prob.next=null;
	    
		removeElements(head,2);
		
		
	}

}
