import java.util.*;
class Solution {
    static int depth;
    static int[][] land;
    static int[] pointx = {-1,0,1,0};
    static int[] pointy = {0,-1,0,1}; 
    public int[] solution(int m, int n, int[][] picture) {
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;        
        int[] answer = new int[2];
        
        land = new int[m][n];
        depth = 1;        
        
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        
        for(int row = 0; row<m;row++)
        {
            for(int col = 0; col<n;col++){
                if(land[row][col]==0 && picture[row][col]!=0){
                    BFS(picture,row,col);
                    depth++;
                }
            }
        }
        
        for(int row = 0; row<m;row++)
        {
            for(int col = 0; col<n;col++)
            {
                if(land[row][col]!=0)
                {
                    numberOfArea = Math.max(numberOfArea,land[row][col]);
                    hs.put(land[row][col],hs.getOrDefault(land[row][col],0)+1);
                }
            }
        }
        
        for(int i : hs.keySet())
        {
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea,hs.get(i));
        }
		
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static public void BFS(int[][] picture,int row,int col)
    {
        land[row][col] = depth;
        
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(row,col));
        
        while(!q.isEmpty())
        {            
            int size = q.size();
            Point p = q.poll();
            for(int sz = 0; sz<size; sz++)
            {                
                int x = p.x;
                int y = p.y;
                for(int c = 0; c < 4; c++)
                {
                    int cx = x + pointx[c];
                    int cy = y + pointy[c];
                    if(cx>=0 && cx<land.length && cy>=0 && cy<land[0].length)
                    {
                        if((picture[cx][cy] == picture[x][y]) && land[cx][cy]==0){
                            land[cx][cy] = depth;
                            q.add(new Point(cx,cy));
                        }
                    }
                }
            }
        }        
    }
}
class Point
{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
