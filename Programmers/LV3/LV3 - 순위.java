import java.util.*;
class Solution {
    static final int INF = Integer.MAX_VALUE / 2;
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] floyd = new int[n+1][n+1];

        for(int r = 1; r<=n;r++)
        {
            for(int c = 1 ; c<=n; c++){
                floyd[r][c] = r==c ? 0 : INF;
            }
        }

        for(int idx = 0; idx<results.length;idx++)
        {
            int r = results[idx][0];
            int c = results[idx][1];

            floyd[r][c] = 1;
        }

        for(int r = 1; r<=n; r++) // 경유지
        { 
            for(int c = 1; c<=n; c++) //시작점
            {
                for(int h = 1; h<=n; h++) // 도착점
                {
                    if(floyd[c][r]  == 1 && floyd[r][h] == 1){
                        floyd[c][h] = 1;
                    }
                }
            }
        }


        for(int r = 1; r<=n; r++)
        {
            int result = 0;
            for(int c=1; c<=n;c++)
            {
                if(floyd[r][c] == 1 || floyd[c][r] == 1){
                    result++;
                }
            }
            if(result == n-1){
                answer++;
            }
        }
        return answer;
    }
}
