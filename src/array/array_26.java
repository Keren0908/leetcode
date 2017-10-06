package array;

import java.util.HashMap;

public class array_26 {
	public static int removeDuplicates(int[] A) {
		int n=A.length;
		if (n == 0)
			return 0;

		int l = 0;
		for (int r = 1; r < n; ++r)
			if (A[r] != A[l])
				A[++l] = A[r];
		return l + 1;
	}
	public static void main(String[] args) {
		int[] nums= {1,1,2,4,4,5,6,6,7};
		System.out.println(removeDuplicates(nums));
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		
	}

}
