
public class Num83_RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numses = {
				{},
				{1},
				{1, 2},
				{1, 1, 1},
				{1, 1, 2},
				{1, 1, 2, 2, 2},
		};
		
		for(int[] nums : numses) {
			ListNode head = ListNode.generateListNode(nums);
			ListNode.printListNodes(deleteDuplicates(head));
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		
		ListNode cur = head;
		ListNode next = head.next;
		
		while(next != null) {
			if(cur.val == next.val) next = next.next;
			else {
				cur.next = next;
				cur = next;
				next = next.next;
			}
		}
		cur.next = null;
		
		return head;
    }

}
