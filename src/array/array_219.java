package array;

public class array_219 {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+k&&j<nums.length;j++){
                if(nums[i]==nums[j])
                    return true;
            }
        }
        return false;
	}
	public static void main(String[] args) {
		int[] nums= {1,2,3,2};
		System.out.println(containsNearbyDuplicate(nums,2));
	}

}
