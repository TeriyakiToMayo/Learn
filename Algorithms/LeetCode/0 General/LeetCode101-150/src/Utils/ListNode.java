package Utils;

public class ListNode {
	public int val;
	public ListNode next;
	public  ListNode(int x) { val = x; }
	
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
			System.out.println("empty");
			return;
		}
		
		ListNode curNode = head;
		System.out.print(curNode.val);
		curNode = curNode.next;
		while(curNode != null) {
			System.out.print("->" + curNode.val);
			curNode = curNode.next;
		}
		System.out.println();
	}
}
