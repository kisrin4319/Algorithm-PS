class Solution {
    public int solution(int n) {
        int answer = 0;        
        
        int[] dp = new int[n+1];        
        
        //fibonacci 수열
        for(int idx = 0; idx<n+1;idx++)
        {
            if(idx<=2){
                dp[idx] = idx;
            } else {
                dp[idx] = dp[idx-1]%1000000007 + dp[idx-2]%1000000007;
            }
        }
        answer = dp[n]%1000000007;
        return answer;
    }
}
