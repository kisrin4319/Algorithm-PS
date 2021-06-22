class Solution 
{
    static int answer = 0;
    static char[][] puzzle;
    public int solution(int m, int n, String[] board) {
        
	boolean init = true;
        puzzle = new char[m][n];
        
        for(int r = 0; r<m; r++)
        {
            puzzle[r] = board[r].toCharArray();
        }
		
        while(init)
        {
            init = Find(puzzle,m,n);
        }        
        return answer;
    }
    
    public boolean Find(char[][] puzzle,int m , int n)
    {
        int cnt = 0;
        boolean[][] pang = new boolean[m][n];
        for(int r = 0; r < m-1; r++)
        {
            for(int c = 0; c < n-1; c++)
            {
                int r1 = r+1;
                int c1 = c+1;
				
                if(puzzle[r][c] == 'X') continue;
                
                if(puzzle[r][c] == puzzle[r1][c] && puzzle[r][c] == puzzle[r][c1] && puzzle[r][c] == puzzle[r1][c1])
		{
                    pang[r][c]   = true;
                    pang[r1][c]  = true;
                    pang[r][c1]  = true;
                    pang[r1][c1] = true;
                }
            }
        }        
        for(int r = 0; r < m; r++)
        {
            for(int c = 0; c < n; c++){
                if(pang[r][c])
		{
                    puzzle[r][c] = 'X';
                    cnt++;
                }
            }
        }
                
        if(cnt == 0){
            return false;
        }
        else {
            answer+=cnt;
            ArrayBatch(puzzle,m,n);
            return true;
        }
        
    }
    
    public void ArrayBatch(char[][] puzzle,int m , int n)
    {        
        for(int c = 0; c < n; c++)
        {
            for(int r = m-2; r >= 0;r--)
            {
                moving(puzzle,r,c);
            }            
        }
    }    
    
    public void moving(char[][] puzzle , int r, int c)
    {                
        while(true)
        {            
            if(r+1>= puzzle.length || puzzle[r+1][c]!= 'X'){
                break;
            }
            
            if(puzzle[r+1][c] == 'X'){
                char ch = puzzle[r][c];
                puzzle[r][c] = 'X';
                puzzle[r+1][c] = ch;
            }
            r++;
        }
    }
}
