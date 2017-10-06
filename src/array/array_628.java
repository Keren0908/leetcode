package array;

import java.util.ArrayList;
import java.util.List;

public class array_628 {
	
		public static int missingNumber(int[] nums) {

		    int xor = 0, i = 0;
			for (i = 0; i < nums.length; i++) {
				xor = xor ^ i ^ nums[i];
			}

			return xor ^ i;
		}

	
	public static void main(String[] args) {
		int[] nums= {3,0,2};
		
		System.out.println(missingNumber(nums));
		List<Integer> list=new ArrayList<Integer>();
		list.se
		
	
	}

}
