class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int row = board.length;
        int col = board[0].length;
        
        int[][] dp = new int[row][col];
        
        dp[0][0] = board[0][0];
        
        for(int r = 1; r<row;r++)
        {
            dp[r][0] = board[r][0];
        }
        
        for(int c = 1; c<col;c++)
        {
            dp[0][c] = board[0][c];
        }
        
        
        for(int r = 1;r<row;r++)
        {
            for(int c =1; c<col;c++)
            {
                if(board[r][c]!=0){
                dp[r][c] =  Math.min(dp[r-1][c], Math.min(dp[r][c-1],dp[r-1][c-1]))+1;
                }
            }
        }

    
        for(int r = 0; r<row;r++)
        {
            for(int c =0; c<col;c++)
            {
                answer = Math.max(answer,dp[r][c]);
                //System.out.print(dp[r][c]+" ");
            }
            //System.out.println("");
        }
        return answer * answer;
    }
}
