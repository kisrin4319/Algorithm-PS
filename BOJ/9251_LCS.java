// LCS(Longest Common Subsequence)
import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		String first  = br.readLine();
		String second = br.readLine();
		
		//문제에서 최대 1000자리 라고 했으니 1001로 배열 설정
		int[][] dp = new int[1001][1001];		
		
		// 첫번째 문자가 같은지 확인
		
		dp[0][0] = first.charAt(0) == second.charAt(0) ? 1: 0;		
		
		// 각 끝라인 초기 세팅
		
		for(int idx = 1; idx<first.length();idx++)
		{
			dp[idx][0] = Math.max(dp[idx-1][0],first.charAt(idx) == second.charAt(0) ? 1:0);
		}
		for(int idx = 1; idx<second.length();idx++)
		{
			dp[0][idx] = Math.max(dp[0][idx-1],first.charAt(0) == second.charAt(idx) ? 1:0);
		}		
		
		// 남은 배열 계산하기
		for(int idx = 1; idx<first.length();idx++)
		{
			for(int idx2 = 1; idx2<second.length();idx2++)
			{
				// 증가하면서 문자 비교하기
				if(first.charAt(idx) == second.charAt(idx2)) {
					dp[idx][idx2] = dp[idx-1][idx2-1]+1; // 같으면 이전 문자에서 일치하는 갯수 증가 
				}
				else {
					dp[idx][idx2] = Math.max(dp[idx-1][idx2],dp[idx][idx2-1]);
				}
			}
		}
		
		System.out.println(dp[first.length()-1][second.length()-1]);		
		
	}
}