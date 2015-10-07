package leetcode;

import java.util.HashMap;

public class twosum {
	public int[] twoSum(int[] nums, int target) {
		int[] index = new int[2];

		for (int i = 0; i < nums.length && Math.abs(nums[i]) <= Math.abs(target); i++) {

			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					index[0] = i + 1;
					index[1] = j + 1;
				}

			}

		}

		return index;
	}
	public int[] twoSum2(int[] nums, int target) {
		int[] index = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])){
				//找到另外一个数字
				int k = map.get(nums[i]);
				index[0] = k+1;
				index[1] = i+1;
			}else{
				map.put(target-nums[i], i);//记录期待值和此时下标
			}
		}
		
		return index;

	}

	public static void main(String[] args) {
		int[] num = { -3,5,3,7,-5 };
		int index[] = new int[2];
		int target = 0;
		twosum to = new twosum();
		index = to.twoSum2(num, target);
		System.out.println(index[0]);
		System.out.println(index[1]);
	}
}
