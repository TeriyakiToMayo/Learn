
public class Num92_ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numses = {
				{},	
				{1},
				{1, 2},
				{1, 2, 3},
				{1, 2, 3, 4, 5},
		};
		
		int[][] ranges = {
				{1, 1},
				{1, 1},
				{1, 2},
				{1, 2},
				{2, 4},
		};
		
		ListNode[] heads = new ListNode[numses.length];
		
		for(int i = 0; i < numses.length; i++) {
			heads[i] = ListNode.generateListNode(numses[i]);
		}
		
		for(int i = 0; i < heads.length; i++) {
			ListNode.printListNodes(heads[i]);
			ListNode head = reverseBetween(heads[i], ranges[i][0], ranges[i][1]);
			IO.outMain("result:");
			ListNode.printListNodes(head);
			IO.outMain("");
		}
		
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		
		if(n - m == 0) return head;
		
		m = m - 1;
		n = n - 1;
		
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		
		ListNode sec1Last = newHead;
		ListNode sec2First = head;
		ListNode sec2Last = null;
		ListNode sec2Last2 = null;
		ListNode sec2LastNext = null;
		ListNode sec3First = null;
		
		int stage = 0;
		for(int i = 0; i <= n; i++) {
			if(stage == 0) {
				if(i < m) {
					sec1Last = sec2First;
					sec2First = sec2First.next;
					continue;
				}
				else if(i == m) {
					sec2Last2 = sec2First;
					sec2Last = sec2First.next;
					stage = 1;
				}
			}else {
				sec2LastNext = sec2Last.next;
				sec2Last.next = sec2Last2;
				if(i < n) {
					sec2Last2 = sec2Last;
					sec2Last = sec2LastNext;
				}else if(i == n) {
					sec3First = sec2LastNext;
					break;
				}
			}
		}
		
		sec1Last.next = sec2Last;
		sec2First.next = sec3First;
		
		return m == 0 ? sec2Last : head;
    }

}
