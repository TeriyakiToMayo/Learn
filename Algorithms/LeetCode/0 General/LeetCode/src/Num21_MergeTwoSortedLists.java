

public class Num21_MergeTwoSortedLists {

	public static class ListNode {
	     int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
		//		{},
		//		{},
		//		{1},
		//		{1, 2, 4},
		//		{1, 2, 2, 2, 4},
				{-10, -10, -9, -4, 1, 6, 6},
				{-10, -9, -6, -4, 1, 9, 9}
		};
		
		int[][] nums2 = {
		//		{},
		//		{1},
		//		{},
		//		{1, 3, 4},
		//		{1, 3, 4},
				{-7}, 
				{-5, -3, 0, 7, 8, 8}
		};
		
		ListNode[] lists = new ListNode[nums.length];
		ListNode[] lists2 = new ListNode[nums2.length];
		
		for(int i = 0; i < nums.length; i++) {
			lists[i] = generateListNode(nums[i]);
			lists2[i] = generateListNode(nums2[i]);
			
			System.out.println("Two lists:");
			printListNodes(lists[i]);
			printListNodes(lists2[i]);
			
			ListNode head = mergeTwoLists(lists[i], lists2[i]);
			
			System.out.println("Result:");
			printListNodes(head);
			System.out.println();
		}
		
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		else if(l2 == null) return l1;
		
		ListNode head;
		if(l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		}
		else {
			head = l2;
			l2 = l2.next;
		}
		
		ListNode curNode = head;
		
		while(true) {
			if(l1 == null) {
				curNode.next = l2;
				break;
			}else if(l2 == null) {
				curNode.next = l1;
				break;
			}
			
			if(l1.val < l2.val) {
				curNode.next = l1;
				while(true) {									//find next different num
					if(l1.next == null)break;
					else if(l1.val != l1.next.val) break;
					l1 = l1.next;
				}
				curNode = l1;
				l1 = l1.next;
			}else {
				curNode.next = l2;
				while(true) {
					if(l2.next == null)break;
					else if(l2.val != l2.next.val) break;
					l2 = l2.next;
				}
				curNode = l2;
				l2 = l2.next;
			}
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
