package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		int len = s.length();
		if (s == null || len % 2 != 0)
			return false;
		for (int i = 0; i < len; i++) {
			if ("{[(".contains(String.valueOf(s.charAt(i))))
				stack.push(s.charAt(i));
			else {
				if (!stack.empty() && is_invalid(stack.peek(), s.charAt(i)))
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}

	private static boolean is_invalid(Character c1, char c2) {
		if (c1 == '(' && c2 == ')' || c1 == '{' && c2 == '}' || c1 == '['
				&& c2 == ']')
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String str = "([])";

		System.out.println(isValid(str));
	}

}
