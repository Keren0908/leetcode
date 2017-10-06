package array;

public class array_122 {
	public static int maxProfit(int[] nums) {
		
		
		int i=0;
		int peak=nums[0];
		int vally=nums[0];
		int maxprofit=0;
		
		while(i<nums.length-1) {
			while(i<nums.length-1&&nums[i]>=nums[i+1])
				i++;
			vally=nums[i];
			while(i<nums.length-1 && nums[i]<=nums[i+1])
				i++;
			peak=nums[i];
			maxprofit+=peak-vally;
			
		}
		return maxprofit;
		
	}

}
