package leetcode;

class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1(int x) {
		val = x;
	}
}

public class AddTwoNumbers {
	public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
		// 安全性检查
		if (l1 == null || l2 == null) {
			return null;
		}
		// 考虑有进位
		int carry = 0;
		ListNode1 result = new ListNode1(0);
		ListNode1 ponit = result;
		// 分三种情况讨论比较好理解
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			ponit.next = new ListNode1(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
			ponit = ponit.next;
		}
		while (l1 != null) {
			int sum = carry + l1.val;
			ponit.next = new ListNode1(sum % 10);
			carry = sum / 10;
			l1 = l1.next;
			ponit = ponit.next;
		}

		while (l2 != null) {
			int sum = carry + l2.val;
			ponit.next = new ListNode1(sum % 10);
			carry = sum / 10;
			l2 = l2.next;
			ponit = ponit.next;
		}
		// 防止最后一位仍有进位
		if (carry != 0) {
			ponit.next = new ListNode1(carry);
		}

		return result.next;
	}
}
