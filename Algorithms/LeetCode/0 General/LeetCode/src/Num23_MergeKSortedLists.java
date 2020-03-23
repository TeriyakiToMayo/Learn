import java.util.Comparator;
import java.util.PriorityQueue;

public class Num23_MergeKSortedLists {

	public static class ListNode {
	     int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] nums = {
				{{}},
				{{}, {1}, {3, 5}},
				{{1, 4, 5}, {2, 3, 4}, {2, 6}},
		};
		
		ListNode[][] lists = new ListNode[nums.length][];
		
		
		for(int i = 0; i < nums.length; i++) {
			lists[i] = new ListNode[nums[i].length];
			System.out.println("input lists: ");
			for(int j = 0; j < nums[i].length; j++) {
				lists[i][j] = generateListNode(nums[i][j]);
				
				printListNodes(lists[i][j]);
			}
		}
		
		for(int i = 0; i < lists.length; i++) {
			ListNode head = mergeKLists(lists[i]);
			printListNodes(head);
		}
		
		
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
        
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val < o2.val) return -1;
				else if(o1.val > o2.val) return 1;
				else return 0;
			}
		};
		
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, comparator);
		
		for(ListNode node : lists) {
			if(node != null) {
				queue.add(node);
			}
		}
		
		ListNode head = queue.isEmpty() ? null : queue.poll();
		if(head != null && head.next != null) queue.add(head.next);
		ListNode curNode = head;
		
		while(!queue.isEmpty()) {
			ListNode node = queue.poll();
			curNode.next = node;
			curNode = node;
			
			if(node.next != null) queue.add(node.next);
		}
		
		return head;
    }
	
	public static ListNode generateListNode(int[] nums) {
		if(nums.length == 0) return null;
		ListNode head = new ListNode(nums[0]);
		ListNode curNode = head;
		
		for(int i = 1; i < nums.length; i++) {
			
			ListNode newNode = new ListNode(nums[i]);
			curNode.next = newNode;
			curNode = newNode;
		}
		
		return head;
	}
	
	public static void printListNodes(ListNode head) {
		if(head == null) {
			System.out.println("empty list");
			return;
		};
		ListNode curNode = head;
//		System.out.println();
		System.out.print(curNode.val);
		curNode = curNode.next;
		while(curNode != null) {
			System.out.print("->" + curNode.val);
			curNode = curNode.next;
		}
		System.out.println();
	}
	
	
}
