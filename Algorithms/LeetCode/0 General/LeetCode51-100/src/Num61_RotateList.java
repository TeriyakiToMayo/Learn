
public class Num61_RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head = ListNode.generateListNode(new int[] {0, 1, 2});
		ListNode newHead = rotateRight(head, 4);
		ListNode.printListNodes(newHead);

	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		
		if(head == null) return null;
		
		ListNode node = head;
		int len = 0;
		while(true) {
			len++;
			if(node.next == null) {
				break;
			}
			node = node.next;
		}
		if(len == 1) return head;
		
		k = k%len;
		if(k == 0) return head;
		
		//pos: the target pos of node, the node will be cut off from the last
		int pos = len - k;
		ListNode last = head;
		ListNode cur = head.next;
		//i from 2 since the 1st loop starts from the 2nd position
		//E.g.: 
		//step0:
		//	1->2->3->4->5->NULL, pos = 3,
		//	0  1    2   3   4
		//	l   c
		//
		//step1 (the 1st loop):
		//	1->2->3->4->5->NULL, pos = 3,
		//	0  1    2   3   4
		//	    l    c
		for(int i = 2; i <= pos; i++) {
			last = cur;
			cur = cur.next;
		}
		
		ListNode newHead = cur;
		last.next = null;
		node.next = head;
        
		return newHead;
    }

}
