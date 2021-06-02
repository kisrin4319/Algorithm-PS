/*
 * LCS(Longest Common Subsequence) 
 * 5582번 : 공통 부분 문자열
 */
import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String first  = br.readLine();
		String second = br.readLine();
		
		int fl = first.length()+1;
		int sl = second.length()+1;
		
		int[][] dp = new int[fl][sl];		
		
		int max = 0;
		for(int row = 1; row<fl; row++)
		{
			for(int col = 1; col<sl; col++)
			{
				if(first.charAt(row-1) == second.charAt(col-1)) {
					dp[row][col] = dp[row-1][col-1]+1;
					max = Math.max(max,dp[row][col]);
				}				 
			}
		}		
		System.out.println(max);
	}
}