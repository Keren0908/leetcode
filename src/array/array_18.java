package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array_18 {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> listp;

		Arrays.sort(nums);
		if (nums[0] * 4 > target || nums[nums.length - 1] * 4 < target)
			return list;

		for (int i = 0; i < nums.length - 3; i++) {
			while (i > 0 && i < nums.length && nums[i] == nums[i - 1])
				i++;
			for (int j = i + 1; j < nums.length - 2; j++) {
				int p = j + 1;
				int q = nums.length - 1;

				while (j > 0 && j < nums.length && nums[j] == nums[j - 1])
					j++;
				while (p < q) {
					int sum = nums[i] + nums[j] + nums[p] + nums[q];
					if (sum < target)
						p++;
					else if (sum > target)
						q--;
					else {
						listp = new ArrayList<Integer>();
						listp.add(nums[i]);
						listp.add(nums[j]);
						listp.add(nums[p]);
						listp.add(nums[q]);
						list.add(listp);
						p++;
						q--;
						while (p > 0 && p < nums.length && nums[p] == nums[p - 1])
							p++;
						while (q >= 0 && q < nums.length - 1 && nums[q] == nums[q + 1])
							q--;
					}
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> p = fourSum(nums, 0);
		System.out.println(p.size());
		for (int i = 0; i < p.size(); i++) {
			for (int w : p.get(i))
				System.out.print(w + " ");
			System.out.println();

		}
	}
}
