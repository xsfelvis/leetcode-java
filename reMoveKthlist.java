package leetcode;

class ListNode2 {
	int val;
	ListNode2 next;

	ListNode2(int x) {
		this.val = x;
	}
}

public class reMoveKthlist {
	public static ListNode2 removeNthFromEnd(ListNode2 head, int n) {
		ListNode2 resultHead = new ListNode2(0);
		resultHead.next = head;
		ListNode2 TempHead = resultHead;
		// 安全性检查
		if (head == null || n < 0)
			return null;
		ListNode2 DeleteHead = head;
		for (int i = 0; i < n; i++) {
			DeleteHead = DeleteHead.next;
		}
		while (DeleteHead != null) {
			DeleteHead = DeleteHead.next;
			TempHead = TempHead.next;
		}
		TempHead.next = TempHead.next.next;
		while (resultHead != null) {
			resultHead = resultHead.next;
			System.out.println(resultHead.val);
		}
		return resultHead.next;
	}

	public static void main(String[] args) {
		ListNode2 lt1 = new ListNode2(1);
		//ListNode2 lt2 = new ListNode2(2);
		//ListNode2 lt3 = new ListNode2(3);
		// ListNode2 lt4 = new ListNode2(4);
		// ListNode2 lt5 = new ListNode2(5);
		//lt1.next = lt2;
		//lt2.next = lt3;
		// lt3.next = lt4;
		// lt4.next = lt5;
		removeNthFromEnd(lt1, 2);
	}
}
