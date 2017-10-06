package array;

import java.util.Arrays;

public class arrayPairSum {
	/*public int arrayPairSum(int[] nums) {
		int N = nums.length;
		int sum = 0;
		sort(nums);
		for (int i = 0; i < N; i = i + 2)
			sum += nums[i];
		return sum;
	}

	private void sort(int[] nums) {
		int N = nums.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--)
				exch(nums, j, j - 1);
		}
	}

	private boolean less(int v, int w) {
		return v < w;
	}

	private void exch(int[] nums, int v, int w) {
		int temp = nums[v];
		nums[v] = nums[w];
		nums[w] = temp;
	}*/
	public int arrayPairSum(int[] nums) {
		int sum=0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i=i+2) {
			sum+=nums[i];
			
		}
		return sum;
	}
		
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6};
		arrayPairSum aps=new arrayPairSum();
	    System.out.println(aps.arrayPairSum(nums));
	    //Arrays.
	}
	

}
