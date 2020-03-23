
public class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
	
	public static ListNode generateListNode(int[] nums) {
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
