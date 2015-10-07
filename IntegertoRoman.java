package leetcode;

import java.util.HashMap;

public class IntegertoRoman {
	public String intToRoman(int num) {
		if (num <= 0)
			return null;

		int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (num > 0) {
			if (num / nums[i] == 0) {
				// 说明num量级不够
				i++;
				continue;
			}
			num -= nums[i];
			// 在字符串找到对应的字符
			sb.append(symbols[i]);
		}
		return sb.toString();

	}
	public String intToRoman1(int num) {
		if(num <= 0) {
			return "";
		}
	    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder res = new StringBuilder();
	    int digit=0;
	    while (num > 0) {
	        int times = num / nums[digit];
	        num -= nums[digit] * times;
	        for ( ; times > 0; times--) {
	            res.append(symbols[digit]);
	        }
	        digit++;
	    }
	    return res.toString();
	}

	public static void main(String[] args) {
		IntegertoRoman is = new IntegertoRoman();
		int m = 95010;
		String out;
		String out1;
		out = is.intToRoman(m);
		out1 = is.intToRoman(m);
		System.out.println(out);
		System.out.println(out1);
	}
}
