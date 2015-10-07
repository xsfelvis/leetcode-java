package leetcode;

/**
 * 隐含的大数问题需要将整型转换为字符串 防止[0,0]
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		// 判断数组元素是否全部为0
		int count = 0;
		for (int i : nums) {
			if (i == 0)
				count++;
		}
		if (count==nums.length)
			return "0";
		int temp = 0;
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				// 假设顺序为m n,若mn<nm则交换顺序
				if (compare(nums[j], nums[j + 1])) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		for (int i : nums) {
			result.append(String.valueOf(i));
		}
		return result.toString();
	}

	private boolean compare(int i, int j) {
		String t1 = String.valueOf(i) + String.valueOf(j);
		String t2 = String.valueOf(j) + String.valueOf(i);
		if (t1.compareTo(t2) <= 0)
			return true;

		else
			return false;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0 };
		LargestNumber LN = new LargestNumber();
		String result;
		result = LN.largestNumber(nums);
		System.out.println(result);
	}
}
