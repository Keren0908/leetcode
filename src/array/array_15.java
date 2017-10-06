package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array_15 {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> listp;

		for (int i = 0; i < nums.length; i++) {

			while (i > 0 && i < nums.length && nums[i] == nums[i - 1])
				i++;
			int j = i + 1;
			int k = nums.length - 1;
			
			while (j < k) {
				int target = nums[i] + nums[j] + nums[k];
				if (target > 0)
					k--;
				else if (target < 0)
					j++;
				else {
					listp = new ArrayList<Integer>();
					listp.add(nums[i]);
					listp.add(nums[j]);
					listp.add(nums[k]);
					list.add(listp);
					j++;
					k--;
					while (j > 0&&j<nums.length && nums[j] == nums[j - 1])
						j++;
					while (k < nums.length - 1 &&k>=0&& nums[k] == nums[k + 1])
						k--;
				}
			}

		}
		return list;

	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0 };
		List<List<Integer>> p = threeSum(nums);
		System.out.println(p.size());
		for (int i = 0; i < p.size(); i++) {
			for (int w : p.get(i))
				System.out.print(w + " ");
			System.out.println();
		}
	}

}
