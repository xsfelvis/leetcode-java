package leetcode;

import java.util.HashMap;

public class RomantoInteger {
	public int romanToInt(String s) {
		// 安全性判断
		if (s == null || s.length() == 0)
			return 0;
		// hash表
		HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();
		numMap.put('I', 1);
		numMap.put('V', 5);
		numMap.put('X', 10);
		numMap.put('L', 50);
		numMap.put('C', 100);
		numMap.put('D', 500);
		numMap.put('M', 1000);
		int len = s.length();
		int result = numMap.get(s.charAt(len - 1));
		for (int i = len - 2; i >= 0; i--) {
			// 比较罗马字符
			if (numMap.get(s.charAt(i + 1)) <=numMap.get(s.charAt(i))) {
				result = result + numMap.get(s.charAt(i));
			} else {
				result = result - numMap.get(s.charAt(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "DCXXI";
		int out;
		RomantoInteger ms = new RomantoInteger();
		out = ms.romanToInt(s);
		System.out.println(out);

	}
}
