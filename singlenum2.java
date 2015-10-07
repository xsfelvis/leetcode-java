package leetcode;

public class singlenum2 {
	class Solution {
	    public int singleNumber(int[] array) {
	        // 安全性检查 数组是否符合3*n+1;
			float len = array.length;
			if(len==1.0)
			return array[0];
			if ((len - 1) % 3 != 0 || len < 4)
				return -1;

			quick_sort(array, 0, array.length - 1);
			int FindNum = array[0];
			int times = 2;
			for (int i = 1; i < len; i++) {
				if (times == 0) {
					// 换下一个数，times置为3重新开始
					FindNum = array[i];
					times = 3;
				}
				if (FindNum == array[i])
					times--;
			}

			return FindNum;
	    }
	    // 快速排序
		private  void quick_sort(int[] arr, int low, int high) {
			// 解决和合并
			if (low <= high) {
				int mid = partition(arr, low, high);
				// 递归
				quick_sort(arr, low, mid - 1);
				quick_sort(arr, mid + 1, high);
			}

		}

		private  int partition(int[] arr, int low, int high) {
			// 分解
			int pivot = arr[high];
			int i = low - 1;
			int temp;
			for (int j = low; j < high; j++) {

				if (arr[j] < pivot) {
					i++;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			// 交换中间元素和privot
			temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;
			return i + 1;

		}
	}
}
