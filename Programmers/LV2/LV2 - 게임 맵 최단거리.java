import java.util.*;
class Solution {
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        answer = BFS(maps);
        
        return answer;
    }
    public int BFS(int[][] maps){
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0,0));
        
        int cnt = 1;
        
        boolean[][] visited = new boolean[n][m];        
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int sz = 0; sz<size;sz++)
            {
                Point p = q.poll();
                int x = p.x;
                int y = p.y;
                
                if(x == n-1 && y == m-1){
                    return cnt;
                }
                for(int cycle = 0; cycle<4;cycle++)
                {
                    int cx = x+dx[cycle];
                    int cy = y+dy[cycle];
                    
                    if(0<=cx && cx<n && 0<=cy && cy<m && maps[cx][cy] == 1 && !visited[cx][cy])
                    {
                        visited[cx][cy]=true;
                        q.offer(new Point(cx,cy));
                    }
                }
            }
            cnt++;
        }
        return -1;
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
