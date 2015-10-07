package leetcode;

import java.util.Arrays;

public class SortColors {
	public void sortColors(int[] nums) {
		// 安全性检查
		int len = nums.length;
		if (len == 0)
			return;
		quickSort(nums, 0, len - 1);
	}

	private void quickSort(int[] arr, int low, int high) {
		int mid;
		if (low <= high) {
			mid = partion(arr, low, high);
			quickSort(arr, low, mid - 1);
			quickSort(arr, mid + 1, high);
		}
	}

	private int partion(int[] arr, int low, int high) {
		int povite = arr[high];
		// 保存下标i
		int i = low - 1;
		int temp;
		for (int j = low; j < high; j++) {
			// 由小到大排序
			if (arr[j] < povite) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// 交换中间元素和povite
		temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	// 冒泡排序
	void BobbleSort(int[] nums) {
		int temp;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len-i; j++) {
				if (nums[j] < nums[j-1]) {
					temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] colors = { 0, 1, 0, 2, 1, 0, 2, 2, 1, 0 };
		SortColors so = new SortColors();
		//so.sortColors(colors);
		so.BobbleSort(colors);
		System.out.println(Arrays.toString(colors));
	}

}
