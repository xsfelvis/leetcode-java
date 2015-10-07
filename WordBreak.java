package leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	/* 递归方法 超时 */
	boolean wordBreak1(String s, Set<String> wordDict) {
		return wordBreakHelper(s, wordDict, 0);
	}

	private boolean wordBreakHelper(String s, Set<String> wordDict, int start) {
		// 递归
		int len, end;
		if (start == s.length())
			return true;
		for (String str : wordDict) {
			len = str.length();
			end = len + start;
			// 如果该字典子串加上上个子串长度大于所需长度则跳过该子串
			if (end > s.length())
				continue;
			if (s.substring(start, start + len).equals(str))
				// 本段字段符合则开始迭代
				if (wordBreakHelper(s, wordDict, start + len))
					return true;

		}
		return false;
	}

	/* dp记录 */
	boolean wordBreak2(String s, Set<String> wordDict) {
		int len = s.length();
		// 定义状态数组并且赋初始值
		boolean[] arrays = new boolean[len + 1];
		arrays[0] = true;
		// 双重循环并且记录状态
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (arrays[j] && wordDict.contains(s.substring(j, i))) {
					arrays[i] = true;
					break;
				}
			}
		}
		return arrays[len];
	}

	public static void main(String[] args) {
		String str = "leetcode";
		HashSet<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		WordBreak wb = new WordBreak();
		//System.out.println(wb.wordBreak1(str, dict));
		System.out.println(wb.wordBreak2(str, dict));
	}
}
