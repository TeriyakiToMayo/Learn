
public class Num86_PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] numses = {
				{},
				{1},
				{1},
				{1, 4, 3, 2, 5, 2},
				{1, 4, 3, 2, 5, 3, 2},
		};
		
		int[] xes = {
				1,
				1,
				2,
				3,
				3,
		};
		
		ListNode[] heads = new ListNode[numses.length];
		
		for(int i = 0; i < numses.length; i++) {
			heads[i] = ListNode.generateListNode(numses[i]);
			
		}
		
		for(int i = 0; i < numses.length; i++) {
			IO.outMain("Nodes: ");
			ListNode.printListNodes(heads[i]);
			IO.outMain("Result:");
			ListNode newHead = partition(heads[i], xes[i]);
			ListNode.printListNodes(newHead);
			IO.outMain("");
		}

	}
	
	public static ListNode partition(ListNode head, int x) {
		
		if(head == null) return null;
		
		ListNode list1newHead = new ListNode(0);
		list1newHead.next = head;
		ListNode list1Last = list1newHead;
		ListNode pointer = head;
		ListNode tmpNext = null;
		ListNode list2Head = new ListNode(0);
		ListNode list2Last = list2Head;
		
		while(pointer != null) {	
			tmpNext = pointer.next;
			pointer.next = null;
			if(pointer.val < x) {
				list2Last.next = pointer;
				list2Last = pointer;
			}else {
				list1Last.next = pointer;
				list1Last = pointer;
			}
			pointer = tmpNext;
		}
		
		list1Last.next = null;
		list2Last.next = list1newHead.next;
		
		return list2Head.next;
    }
}
