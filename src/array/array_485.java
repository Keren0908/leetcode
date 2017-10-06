package array;

public class array_485 {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int max = 0;
		int i = 0;
		while (i < nums.length) {
			while (i < nums.length && nums[i++] == 1)
				count++;
			if (count > max)
				max = count;
			count = 0;
			while (i < nums.length && nums[i++] == 0)
				;

		}
		return max;

	}
	public static void main(String[] args) {
		int[] a= {1,0,0,1,1,0,1};
		System.out.println(findMaxConsecutiveOnes(a));
	}

}
