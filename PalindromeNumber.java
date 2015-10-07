package leetcode;

/*
 * 判断是否为回文数
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		// 利用ReverseInteger解题思路
		int temp = x;// 记录X的值
		int result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}

		return temp == result;
	}
	public static void main(String[] args) {
		int a = 123321;
		PalindromeNumber pa = new PalindromeNumber();
		boolean flag;
		flag = pa.isPalindrome(a);
		System.out.println(flag);
	}
}
