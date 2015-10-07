package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<Integer>();
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int target;
		for (int i = 0; i < nums.length; i++) {
			// 最外层循环,问题归结为找target为0-nums[i]的数字
			for (int j = i + 1; j < nums.length; j++) {
				target = 0 - nums[i];
				if (map.containsKey(nums[j])) {
					arr.add(nums[i]);
					arr.add(0 - nums[i] - nums[j]);
					arr.add(nums[j]);
					if (!result.contains(arr))
						result.add(arr);
					arr = new ArrayList<Integer>();
				} else {
					map.put(target - nums[j], j);
				}
			}
			map.clear();

		}

		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int num[] = { -1, 0, 1, 2, -1, -4 };
		ThreeSum tsm = new ThreeSum();
		result = tsm.threeSum(num);
		System.out.println(result);

	}
}
