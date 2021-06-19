import java.util.*;

public class Main {
    
    static int N,M,time=0,prevcnt=0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] cheese;
    static boolean[][] OutSide;
    static ArrayList<Point> Camera = new ArrayList<Point>();
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
    
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        cheese = new int[N][M];
        OutSide = new boolean[N][M];
        
        for(int r = 0; r < N; r++)
        {
            for(int c = 0; c < M; c++)
            {
                cheese[r][c] = sc.nextInt();
                if(cheese[r][c] == 1) {
                    prevcnt++;
                }
            }
        }
        
        boolean init = true;
        while(init)
        {
            int x = 0;
            int y = 0;
            time++;            
            find:for(int row = 0; row<N;row++) {
                for(int col = 0; col<M;col++) {
                    if(cheese[row][col] == 0 && !OutSide[row][col]) {
                        x = row;
                        y = col;
                        break find;
                    }
                }
            }
            if(!FindOutSide(x,y)) 
            {
                init = false;
            }
            else {
                
                for(int row = 0; row<N;row++)
                {
                    Arrays.fill(OutSide[row], false);
                }
            }
        }
        
        System.out.println(time);
        System.out.println(prevcnt);
        sc.close();
    }


    private static boolean FindOutSide(int r, int c)
    {
        Queue<Point> q = new LinkedList<Point>();
        
        q.add(new Point(r,c));
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int sz = 0; sz<size;sz++)
            {
                Point p = q.poll();
                
                int x = p.x;
                int y = p.y;
                
                for(int cycle = 0; cycle < 4; cycle++)
                {
                    int cx = x+dx[cycle];
                    int cy = y+dy[cycle];
                    
                    if(0<=cx && cx<N && 0<=cy && cy<M && !OutSide[cx][cy] && cheese[cx][cy] == 0) {
                        OutSide[cx][cy] = true;
                        q.add(new Point(cx,cy));
                    }
                }
            }
        }
        if(!MeltDown(OutSide)) {
            return false;
        }
        else {
            return true;
        }
    }

    private static boolean MeltDown(boolean[][] OutSide)
    {        
        for(int r = 0; r<N; r++)
        {
            for(int c = 0; c<M; c++)
            {
                if(cheese[r][c] == 1) {
                    if( 0<= r-1 && r+1<N && 0<=c-1 && c+1 <M) {
                        if(OutSide[r-1][c] || OutSide[r+1][c] || OutSide[r][c-1] || OutSide[r][c+1] ) {
                            cheese[r][c]--;
                        }
                    }
                }
            }
        }
        int cnt = CountCheese(cheese);        
        if(cnt!=0) {
            prevcnt = cnt;
        }        
        if(cnt ==0) {
            return false;
        }
        else {
            return true;
        }
    }

    private static int CountCheese(int[][] copyCheese)
    {
        int cnt = 0;
        for(int r = 0; r<N;r++)
        {
            for(int c =0; c<M;c++)
            {
                if(copyCheese[r][c] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
        
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