package array;

import java.util.ArrayList;
import java.util.List;

public class array448 {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ext=new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
           if(nums[Math.abs(nums[i])-1]>0)
               nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                ext.add(i+1);
        }
        return ext;
	}
	public static void main(String[] args) {
		int[] nums= {4,3,2,7,8,2,3,1};
		System.out.print(findDisappearedNumbers(nums));
		int z=0;
		for(int i=0,j=5;i<j;i++,j--)
			z+=1;
			
	}

}
