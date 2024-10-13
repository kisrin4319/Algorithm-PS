import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        
        //PrintArray(board);
        
        for(int idx = 0; idx<moves.length;idx++)
        {
            int col = moves[idx]-1;
            int row = FindDolls(board,col);
                        
            int value = board[row][col];
            
            if(!st.isEmpty() && st.peek() == value)
            {
                st.pop();
                answer+=2;
            }
            else
            {
                if(value!=0) st.push(value);
            }
            board[row][col] = 0;
        }
        return answer;
    }
    
    public int FindDolls(int[][] board, int col){
        
        int row = 0;
        boolean init = false;
        for(int r = 0; r<board.length;r++){
            if(board[r][col]!=0){
                row = r;
                init = true;
                break;
            }
        }
        return init ? row : 0 ;
    }
    
    public void PrintArray(int[][] board){
        for(int r = 0; r<board.length;r++){
            for(int c = 0; c<board[r].length;c++)
            {
                System.out.print(board[r][c] +" ");
            }
            System.out.println();
        }
    }
}
