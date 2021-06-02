/*
 * LCS(Longest Common Subsequence)
 * 9252 LCS 2 
 * 9251 LCS 문제 변형 해서 하려 했는데 뭔가 잘못 된 거 같아서 다시 코딩...
 * LCS의 핵심은 같으면 대각선 왼쪽 위 , 다르면 왼쪽,위쪽의 값 중 큰 것을 설정 하는것 같다.
 */
import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		String first  = br.readLine();
		String second = br.readLine();
		
		int fl = first.length()+1;
		int sl = second.length()+1;
		
		int[][] dp = new int[fl][sl];		
		
		for(int row = 1; row<fl; row++)
		{
			for(int col = 1; col<sl; col++)
			{
				if(first.charAt(row-1) == second.charAt(col-1)) {
					dp[row][col] = dp[row-1][col-1]+1;
				}
				else {
					dp[row][col] = Math.max(dp[row-1][col],dp[row][col-1]);
				}				 
			}
		}				
		
		
		// 데이터 확인용 Print
//		for(int row = 0; row<fl;row++)
//		{
//			for(int col = 0; col<sl;col++)
//			{
//				System.out.print(dp[row][col]+ " ");
//			}
//			System.out.println("");
//		}
		
		//부분 문자열을 찾아보자
		
		int row = first.length();
		int col = second.length();
		
		while(row>0 && col>0) {
									
			if(dp[row][col]== dp[row-1][col]) // 위의 값과 같다면?
			{
				row--;
			}
			else if(dp[row][col]== dp[row][col-1]) //왼쪽의 값과 같다면?
			{
				col--;
			}
			else {
				sb.append(first.charAt(row-1));
				row--;
				col--;
			}
		}
		
		//역으로 추적하는 거니까 Reverse
		sb.reverse();
		
		System.out.println(dp[fl-1][sl-1]);
		System.out.println(sb);
	}
}