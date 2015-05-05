//package leetcode;

public class RemoveLinkedListElements_203 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//				Return: 1 --> 2 --> 3 --> 4 --> 5
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(1);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(1);
		ListNode n6=new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		
		RemoveLinkedListElements_203 test=new RemoveLinkedListElements_203();
		ListNode r=test.removeElements(n1,1);
		if(r!=null)
			System.out.println(r.toString());
		
	}

	//this is for finding the ListNode which has the value of val
	public ListNode removeElements2(ListNode head, int val) {
		if(head==null){
			return null;
		}
		ListNode current=head;
		while(current!=null){
			if(current.val==val){
				return current;
			}else{
				current=current.next;
			}
		}
		return null;
	}
	
/**	Time Limit Exceeded
	Status: Wrong Answer
	Submitted: 3 minutes ago
	Input:	[1,1], 1
	Output:	[1]
	Expected:	[]
	*/
	public ListNode removeElements3(ListNode head, int val) {
		if(head==null){
			return null;
		}
		ListNode current=head;
		ListNode previous=null;
		while(current!=null){
			if(current.val==val&&previous==null){
				head=current.next;
				if(head==null)return null;
				current=head.next;
				previous=head;
			}else if(current.val==val&&previous!=null){
				previous.next=current.next;
				current=previous.next;
			}else{
				previous=current;
				current=current.next;
			}
		}
		return head;
	}

	
	/**Runtime: 366 ms**/
	public ListNode removeElements(ListNode head, int val) {
		if(head==null){
			return null;
		}
		if(head.val==val){
			head=head.next;
			return removeElements(head,val);
		}else{
			head.next=removeElements(head.next,val);
			return head;
		}
	}
}

