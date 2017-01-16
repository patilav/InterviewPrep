package arrays.twodimentional;

public class ZigZagMatrix {

	
	public static void main(String [] args){
		String [][] m = new String[][]{
			  { "A","B","C","D"},
			  { "E","F","G","H"},
			  { "I","J","K","L"}
			};
			printMatrix(m);
	}
	
	public static void printMatrix(String m[][]){
		
		for(int i = 0; i<m.length; i++){
			helper(m, i, 0);
			System.out.print("| ");
		}
		
		for(int i = 1; i<=m.length; i++){
			helper(m, m.length-1, i);
			System.out.print("| ");
		}
		
	}
	
	public static void helper(String m[][], int row, int column){
		for(int i=column; i<= m.length; i++){
			if(row>=0){
				System.out.print(m[row][i] +" ");
			} else{
				break;
			}
			row--;
		}
	}
}
