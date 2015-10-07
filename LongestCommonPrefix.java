package leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < strs[i].length() && j < prefix.length()
					&& strs[i].charAt(j) == prefix.charAt(j)) {
				j++;
			}
			if (j == 0) {
				return "";
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}

	public static void main(String[] args) {
		LongestCommonPrefix lg = new LongestCommonPrefix();
		String result;
		String[] strs = { "aac", "aacab", "aac", "aabba", "aa" };
		result = lg.longestCommonPrefix(strs);
		System.out.println(result);

	}
}
