package leetcode;
/**
 * 将链表一分为二
 * 采用归并排序
 */

//定义单链表
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}
public class MergerSort {
	public ListNode sortList(ListNode head) {
		//安全性检查
		if(head == null||head.next==null)
			return null;
		//计算链表长度
		int count = getListConut(head);
		//将链表截断
		int mid = count/2;
		
		//将前半部分链表的尾部补上null
		ListNode l = head,r = null;
		ListNode p2 = head;
		int tempCount = 0;
		while(p2!=null){
			tempCount++;
			ListNode next = p2.next;
			if(tempCount==mid){
				p2.next = null;
				r = next;
			}
			p2 = next;		
		}
		
		//现在有2部分需要分别递归处理
		ListNode h1 = sortList(l);
		ListNode h2 = sortList(r);
		//合并
		ListNode mergered = merge(h1,h2);
		return mergered;
		
		
	}
	private ListNode merge(ListNode l, ListNode r) {
		ListNode p1 = l;
		ListNode p2 = r;
		
		//开辟一个空间作为合并后链表的存储
		ListNode Temphead = new ListNode(100);
		ListNode pNew = Temphead;
		//对链表进行排序
		while(p1!=null||p2!=null){
			if (p1 == null) {
				pNew.next = new ListNode(p2.val);
				p2 = p2.next;
				pNew = pNew.next;
			} else if (p2 == null) {
				pNew.next = new ListNode(p1.val);
				p1 = p1.next;
				pNew = pNew.next;
			} else {
				if (p1.val < p2.val) {
					// if(fakeHead)
					pNew.next = new ListNode(p1.val);
					p1 = p1.next;
					pNew = pNew.next;
				} else if (p1.val == p2.val) {
					pNew.next = new ListNode(p1.val);
					pNew.next.next = new ListNode(p1.val);
					pNew = pNew.next.next;
					p1 = p1.next;
					p2 = p2.next;
 
				} else {
					pNew.next = new ListNode(p2.val);
					p2 = p2.next;
					pNew = pNew.next;
				}
			}
		}
		
		return null;
	}
	private int getListConut(ListNode p) {
		int count = 0;
		while(p!=null){
			count++;
			p = p.next;
		}
		return count;
	}
}
