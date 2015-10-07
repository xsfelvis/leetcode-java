package leetcode;

/*1. null or empty string
 2. white spaces
 3. +/- sign
 4. calculate real value
 5. handle min & max
 */
public class StringtoInteger {
	public int myAtoi1(String str) {
		// 安全性检查
		if (str.length() == 0 || str == null)
			return 0;

		// trim过滤空格
		str = str.trim();
		// 考虑正负数
		int i = 0;
		if (str.charAt(0) == '+')
			i++;
		if (str.charAt(0) == '-')
			i++;
		double resultNum = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			resultNum = resultNum * 10 + (str.charAt(i) - '0');
			i++;
		}
		// 输出结果
		if (str.charAt(0) == '-')
			resultNum = -resultNum;
		if (str.charAt(0) == '+') {
			if (resultNum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;

		}

		if (str.charAt(0) == '-') {
			if (resultNum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;

		}

		return (int) resultNum;

	}

	public static void main(String[] args) {
		String str = "2147483648";
		int num;

		StringtoInteger st = new StringtoInteger();
		num = st.myAtoi1(str);
		System.out.println(num);

	}
}
