/* 
 * 다이나믹 프로그래밍, 문자열
 * 1958번 : LCS 3
 */
import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();;
		char[] C = br.readLine().toCharArray();;
		
		
		int[][][] dp = new int[A.length+1][B.length+1][C.length+1];
		
		
		for(int row = 1; row<A.length+1; row++)
		{
			for(int col = 1; col<B.length+1; col++)
			{
				for(int depth = 1; depth<C.length+1; depth++)
				{
					if(A[row-1] == B[col-1] && B[col-1] == C[depth-1]) {
						dp[row][col][depth] = dp[row-1][col-1][depth-1]+1;
					}
					else {
						dp[row][col][depth] = Math.max(dp[row-1][col][depth],Math.max(dp[row][col-1][depth],dp[row][col][depth-1]));
					}
				}
			}
		}
		
		System.out.println(dp[A.length][B.length][C.length]);
	}
}