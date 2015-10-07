package leetcode;

public class SingleNUm {
	public int singleNumber(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return -1;
		int result = 0;

		for (int i = 0; i < len; i++) {
			result = result ^ nums[i];
		}
		return result;
	}
	public static void main(String[] args) {
		SingleNUm sg = new SingleNUm();
		int[] re  ={2,3,2,3,4,5,4};
		int result = sg.singleNumber(re);
		System.out.println(result);
	}
}
