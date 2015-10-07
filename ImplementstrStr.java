package leetcode;

public class ImplementstrStr {

	// 普通的解法
	public int strStr(String haystack, String needle) {
		// 安全性检查
		if (haystack == null || needle == null)
			return 0;
		if (needle.length() == 0)
			return 0;
		// index位置
		int indexFlag;
		// 双重循环判断
		for (int i = 0; i < haystack.length(); i++) {
			// 如果找到第一个开始的元素但是后面的长度不够仍需要退出
			if (i + needle.length() > haystack.length())
				return -1;
			indexFlag = i;
			for (int j = 0; j < needle.length(); j++) {

				if (haystack.charAt(indexFlag) == needle.charAt(j)) {
					if (j == needle.length() - 1)
						return i;
					indexFlag++;
				} else
					break;
			}
		}
		return -1;
	}

	/**
	 * KMP解法 具体的匹配
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public int kMPMatcher(String str1, String str2) {

		int i = 0, j = -1;
		int arr[] = next(str2);

		while (i < str1.length() && j < str2.length()) {

			if (j == -1 || str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			} else
				j = arr[j];

		}
		if (j == str2.length())
			return i - j;

		return -1;
	}

	/**
	 * next函数
	 * 
	 * @param str
	 * @return
	 */
	public int[] next(String str) {

		int j = -1, i = 0;
		int arr[] = new int[str.length() + 1];
		arr[0] = -1;

		while (i < str.length()) {
			if (j == -1 || str.charAt(i) == str.charAt(j)) {
				j++;
				i++;
				arr[i] = j;
			}

			else
				j = arr[j];

		}

		return arr;
	}

	public static void main(String[] args) {
		int index, index1;
		String str1 = "acbcdbd";
		String str2 = "bcd";
		ImplementstrStr imps = new ImplementstrStr();
		//index = imps.strStr(str1, str2);
		index1 = imps.kMPMatcher(str1, str2);
		//System.out.println(index);
		System.out.println(index1);

	}
}