package array;

public class array_79 {
	private static boolean[][] visited;
	public static boolean exist(char[][] board, String word) {
		int row=board.length;
		int col=board[0].length;
		
		visited=new boolean[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) 
				if(exist(board,i,j,word,0,visited)) return true;
			}
		return false;
		}
	
	private static boolean exist(char[][] board,int row,int col,String word,int index,boolean[][] visited) {
		if(index==word.length()) return true;
		if(row<0||col<0||row>=board.length||col>=board[0].length||visited[row][col]||board[row][col]!=word.charAt(index))
			return false;
		
		visited[row][col]=true;
		boolean exist=exist(board,row-1,col,word,index+1,visited)||
					  exist(board,row+1,col,word,index+1,visited)||
					  exist(board,row,col-1,word,index+1,visited)||
					  exist(board,row,col+1,word,index+1,visited);
		
		visited[row][col]=false;
		return exist;
	}
	public static void main(String[] args) {
		char[][] board= {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		System.out.println(exist(board,"SEE"));
		
	}

}
