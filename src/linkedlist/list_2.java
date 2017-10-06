package linkedlist;

import linkedlist.list_203.ListNode;

public class list_2 {
	public static class ListNode {
		      int val;
		     ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int carry=0;
	        int sum=0;
	        
	        ListNode head=new ListNode(0);
	        head.val=(l1.val+l2.val+carry)%10;
	        carry=(l1.val+l2.val+carry)/10;
	        l1=l1.next;
	        l2=l2.next;
	        ListNode prob=head;
	        
	        while(l1!=null||l2!=null||carry!=0){
	            sum=(l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
	            carry=sum/10;
	            prob.next=new ListNode(sum%10);
	            prob=prob.next;
	            l1=l1.next;
		        l2=l2.next;
	        }
	        prob.next=null;
	        return head;     
	    }
	 public static void main(String[] args) {
			ListNode head=new ListNode(1);
			ListNode prob=head;
			for(int i=2;i<3;i++) {
				prob.next=new ListNode(i);
				prob=prob.next;
				
			}
			ListNode head1=new ListNode(1);
			ListNode prob1=head1;
			for(int i=2;i<3;i++) {
				prob1.next=new ListNode(i);
				prob1=prob1.next;
				
			}
			
			addTwoNumbers(head,head1);
			
	 }	    

}
