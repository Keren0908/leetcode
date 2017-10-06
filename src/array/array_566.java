package array;

public class array_566 {
	public static int[][] matrixReshape(int[][] nums,int r,int c){
		int or=nums.length;  //original matrix's rows
		int oc=nums[0].length;  //columns;
		int[][] new_nums=new int[r][c];
		
		if(r*c!=or*oc) return nums;
		
		int max=r*c;
		//System.out.println(max);
		
		for(int i=0;i<max;i++) 
			new_nums[i/c][i%c]=nums[i/oc][i%oc];
		
		return new_nums;
	}
	
		public static void main(String[] args) {
			int[][] a= {{0,1,2,3,4},
					{5,6,7,8,9}};
			int[][] c=matrixReshape(a,1,10);
			for(int i=0;i<c.length;i++) {
				for(int j=0;j<c[0].length;j++) {
					System.out.println(c[i][j]);
				}
			}
			}
		
		
		
		
	}


