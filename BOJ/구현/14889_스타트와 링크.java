import java.util.*;

public class Main {
    
    static int N,answer = Integer.MAX_VALUE;
    static int[][] map;
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
    
        
        N = sc.nextInt();
        
        map = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];
        
        for(int r = 1; r < N+1; r++)
        {
            for(int c = 1; c < N+1; c++)
            {
                map[r][c] = sc.nextInt();
            }
        }
        
        MakeTeam(visited,1,0);
        
     //   PrintArray(map);

        System.out.println(answer);
            
        sc.close();
    }

    private static void MakeTeam(boolean[] visited,int idx,int cnt)
    {        
        if(cnt == N/2) 
        {
            answer = Math.min(Calculate(visited),answer);
            return;
        }
        
        for(int i = idx; i<N;i++)
        {
            visited[i]= true;
            MakeTeam(visited,i+1,cnt+1);
            visited[i] = false;
        }
    }

    private static int Calculate(boolean[] visited) {
        
        int diff = 0;        
        int ASum = 0;
        int BSum = 0;
                
        for(int row = 1;row<N+1;row++) {
            for(int col =1;col<N+1;col++)
            {
                if(row!=col && visited[row] && visited[col]) {
                    ASum+= map[row][col];
                }
                else if(row!=col && !visited[row] && !visited[col])
                {
                    BSum+= map[row][col];
                }
            }
        }
        
        diff = Math.abs(ASum-BSum);
        
        return diff;
    }

    private static void PrintArray(int[][] map)
    {        
        for(int r = 0; r < N; r++)
        {
            for(int c = 0; c < N; c++)
            {
                System.out.printf("%3d",map[r][c]);
            }
            System.out.println("");
        }        
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}