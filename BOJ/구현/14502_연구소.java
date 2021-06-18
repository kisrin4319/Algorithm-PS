import java.util.*;

public class Main {
    
    static int N,M,cnt;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> virus;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[N][M];
        visited = new boolean[N][M];
        virus = new ArrayList<Point>();
        
        for(int r = 0; r<N; r++)
        {
            for(int c =0; c<M; c++)
            {
                map[r][c] = sc.nextInt();
                if(map[r][c] == 2) {
                    virus.add(new Point(r,c));
                }
            }
        }
        
        Stack<Point> st = new Stack<Point>();
        
        cnt = Math.max(Virus(st),cnt); // 아무 벽도 설치 안했을 경우
        WallSet(st,0,0); // 벽을 설치 할 경우
        
        
        System.out.println(cnt);
        
        sc.close();
    }
    private static void WallSet(Stack<Point> st , int row, int col) {
        
        if(st.size()== 3) {        
            cnt = Math.max(Virus(st),cnt);
            return;
        }
        
        
        for(int i = row;i<N;i++)
        {
            for(int j =0; j<M; j++) {
                if(i==row && j<col) continue;
                
                if(map[i][j] == 0)
                {
                    st.push(new Point(i,j));
                    WallSet(st,i,j+1);
                    st.pop();
                }
            }
        }
    }
    private static int Virus(Stack<Point> st)
    {
        Queue<Point> q = new LinkedList<Point>();
        Stack<Point> s = (Stack<Point>) st.clone();
        
         
        int[][] copyMap = ArrayCopy(map);
        
        while(!s.isEmpty())
        {
            Point w = s.pop();
            copyMap[w.x][w.y] = 1;            
        }
        
        
        //System.out.println("set wall");
        
        //PrintArray(copyMap);    
        
        for(int idx = 0; idx<virus.size();idx++)
        {
            Point v = virus.get(idx);
            q.add(new Point(v.x,v.y));
        }
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int sz = 0; sz<size;sz++)
            {
                Point p = q.poll();
                
                int x = p.x;
                int y = p.y;
                
                for(int dr = 0; dr<4; dr++)
                {
                    int cx = x+dx[dr];
                    int cy = y+dy[dr];
                    
                    if(0<=cx && cx<N && 0<=cy && cy<M && copyMap[cx][cy] == 0) {
                        copyMap[cx][cy] = 2;
                        q.add(new Point(cx,cy));
                    }
                }
            }
        }
        
        //System.out.println("After Spread");
        //PrintArray(copyMap);
        
        return SafeZone(copyMap);
        
        
    }
    private static int SafeZone(int[][] Zone) {
        int answer = 0;
        
        for(int r = 0; r<N;r++)
        {
            for(int c = 0; c<M; c++)
            {
                if(Zone[r][c] ==0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    private static int[][] ArrayCopy(int[][] origin)
    {
        int[][] copy = new int[N][M];
        
        for(int r = 0; r<N;r++)
        {
            for(int c = 0; c<M; c++)
            {
                copy[r][c] = origin[r][c];
            }
        }
     
        return copy;
    }
    
    private static void PrintArray(int[][] origin)
    {
        for(int r = 0; r<N;r++)
        {
            for(int c = 0; c<M; c++)
            {
                System.out.printf("%3d ",origin[r][c]);
            }
            System.out.println("");
        }
    }
    
}
class Point
{
    int x;
    int y;
    
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}