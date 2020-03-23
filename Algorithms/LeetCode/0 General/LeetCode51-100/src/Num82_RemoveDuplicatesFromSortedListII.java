
public class Num82_RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] numses = {
				{},
				{1},
				{1, 2},
				{1, 1, 1},
				{1, 1, 2},
				{1, 1, 2, 2, 2},
				{1, 1, 1, 2, 3},
				{1, 2, 3, 3, 4, 4, 5},
		};
		
		for(int[] nums : numses) {
			ListNode head = ListNode.generateListNode(nums);
			ListNode.printListNodes(deleteDuplicates(head));
		}

	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		
		if(head == null) return null;
		
		ListNode newHead = new ListNode(0);
		ListNode lastOfNew = newHead;
		ListNode cur = head;
		lastOfNew.next = cur;
		
		
		while(lastOfNew.next != null) {
			
			//find the last of current section
			while(true) {
				if(cur.next == null || cur.val != cur.next.val) break;
				else cur = cur.next;
			}
			
			if(lastOfNew.next == cur) lastOfNew = cur;
			else lastOfNew.next = cur.next;
			cur = cur.next;
		}
		
		return newHead.next;
    }

}
